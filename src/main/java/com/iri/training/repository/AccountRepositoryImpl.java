package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.model.Account;
import com.iri.training.model.builder.AccountBuilder;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

	Logger logger = Logger.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();

	@Override
	public Account getAccount(final String username) throws SQLException {

		logger.debug("ENTERED getAccount for username: " + username);

		final Account account;

		jdbcTemplate = new JdbcTemplate(dataSource);
		account = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_BY_USERNAME,
			new Object[]{username},
			new AccountResultSetExtractor());

		logger.debug("EXITING getAccount: " + account);

		return account;
	}

	@Override
	public Account getAccountById(Long accountId ) throws SQLException {

		logger.debug("ENTERED getAccountById for accountId: " + accountId);

		final Account account;
		jdbcTemplate = new JdbcTemplate(dataSource);
		account = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_BY_ID,
			new Object[]{accountId},
			new AccountResultSetExtractor());

		logger.debug("EXITING getAccountById: " + account);

		return account;
	}

	@Override public Account getAccountByEmail(final String email) throws SQLException {

		logger.debug("ENTERED getAccountByEmail for email: " + email);

		final Account account;
		jdbcTemplate = new JdbcTemplate(dataSource);
		account = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_BY_EMAIL,
			new Object[]{email},
			new AccountResultSetExtractor());

		logger.debug("EXITING getAccountByEmail: " + account);

		return account;
	}

	@Override
	public List<Account> getAccountList() throws SQLException {

		logger.debug("ENTERED getAccountList");

		final List<Account> accountsList;
		jdbcTemplate = new JdbcTemplate(dataSource);
		accountsList = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_LIST,
			new AccountListResultSetExtractor());

		logger.debug("EXITING getAccountList: " + accountsList);

		return accountsList;
	}

	@Override
	public void createAccount(final Account account) throws SQLException {

		logger.debug("ENTERED createAccount for account: " + account);

		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(PropertiesConfig.ADD_ACCOUNT,
			account.getAccountId(),
			account.getUsername(),
			account.getPassword(),
			account.getEmail());

		logger.debug("EXITING createAccount: " + account);
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
