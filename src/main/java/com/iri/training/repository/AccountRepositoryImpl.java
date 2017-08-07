package com.iri.training.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.model.Account;
import com.iri.training.model.builder.AccountBuilder;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	Logger logger = Logger.getLogger(AccountRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	InputStream resourceAsStream = AccountRepositoryImpl.class.getResourceAsStream("/sql_queries.properties");
	//private FileInputStream fis = new FileInputStream("src/main/resources/sql_queries.properties");
	private PropertyResourceBundle property = new PropertyResourceBundle(resourceAsStream);

	public AccountRepositoryImpl() throws IOException {}

	@Override
	public Account getAccount(final String username) throws SQLException {
		logger.debug("ENTERED getAccount for username: " + username);

		final Account account;
		String sql = property.getString("RETRIEVE_ACCOUNT_BY_USERNAME");
		jdbcTemplate = new JdbcTemplate(dataSource);
		account = jdbcTemplate.query(sql, new Object[]{username}, new AccountResultSetExtractor());

		logger.debug("EXITING getAccount: " + account);

		return account;
	}

	@Override
	public Account getAccountById(Long accountId ) throws SQLException {
		logger.debug("ENTERED getAccountById for accountId: " + accountId);

		final Account account;
		String sql = property.getString("RETRIEVE_ACCOUNT_BY_ID");
		jdbcTemplate = new JdbcTemplate(dataSource);
		account = jdbcTemplate.query(sql, new Object[]{accountId}, new AccountResultSetExtractor());

		logger.debug("EXITING getAccountById: " + account);

		return account;
	}

	@Override public Account getAccountByEmail(final String email) throws SQLException {
		logger.debug("ENTERED getAccountByEmail for email: " + email);

		final Account account;
		String sql = property.getString("RETRIEVE_ACCOUNT_BY_EMAIL");
		jdbcTemplate = new JdbcTemplate(dataSource);
		account = jdbcTemplate.query(sql, new Object[]{email}, new AccountResultSetExtractor());

		logger.debug("EXITING getAccountByEmail: " + account);

		return account;
	}

	@Override
	public List<Account> getAccountList() throws SQLException {
		logger.debug("ENTERED getAccountList");

		String sql = property.getString("RETRIEVE_ACCOUNT_LIST");
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Account> accountsList = jdbcTemplate.query(sql, new AccountListResultSetExtractor());

		logger.debug("EXITING getAccountList: " + accountsList);

		return accountsList;
	}

	@Override
	public Account createAccount(final Account account) throws SQLException {

		logger.debug("ENTERED createAccount for account: " + account);

		String sql = property.getString("CREATE_ACCOUNT");
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, account.getUsername(),
								 account.getPassword(),
								 account.getEmail());

		logger.debug("EXITING createAccount: " + account);

		return account;
	}

	private static final class AccountResultSetExtractor implements ResultSetExtractor<Account> {

		@Override
		public Account extractData(final ResultSet resultSet) throws SQLException {

			final Account account;

			if (resultSet.next()) {
				account = new AccountBuilder()
					.withAccountId(resultSet.getLong("accountId"))
					.withUsername(resultSet.getString("username"))
					.withPassword(resultSet.getString("password"))
					.withEmail(resultSet.getString("email"))
					.build();
			}
			else
			{
				return null;
			}

			return account;
		}
	}

	private static final class AccountListResultSetExtractor implements ResultSetExtractor<List<Account>> {

		@Override
		public List<Account> extractData(final ResultSet resultSet) throws SQLException {

			final List<Account> accountList = new ArrayList<>();
			while (resultSet.next()) {
				accountList.add(new AccountBuilder()
					.withUsername(resultSet.getString("username"))
					.withAccountId(resultSet.getLong("accountId"))
					.withEmail(resultSet.getString("email"))
					.build());
			}

			return accountList;
		}
	}
}
