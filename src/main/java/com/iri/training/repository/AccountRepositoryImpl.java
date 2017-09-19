package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

	private static final Logger logger = Logger.getLogger(UserRepository.class);

	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private JdbcTemplate jdbcTemplate;

	@Override
	public final Account getAccountById(final long accountId) throws SQLException {

		logger.debug("ENTERED getAccountById for accountId: " + accountId);

		final Account account;
		jdbcTemplate = new JdbcTemplate(dataSource);

		account = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_BY_ID,
			new Object[]{accountId},
			new AccountResultSetExtractor());

		logger.debug("EXITING getAccountById with account: " + account);

		return account;
	}

	@Override
	public final Account getAccountByUsername(final String username) throws SQLException {

		logger.debug("ENTERED getAccountByUsername for username: " + username);

		final Account account;
		jdbcTemplate = new JdbcTemplate(dataSource);

		account = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_BY_USERNAME,
			new Object[]{username},
			new AccountResultSetExtractor());

		logger.debug("EXITING getAccountByUsername with account: " + account);

		return account;
	}

	@Override
	public final Account getAccountByEmail(final String email) throws SQLException {

		logger.debug("ENTERED getAccountByEmail for email: " + email);

		final Account account;
		jdbcTemplate = new JdbcTemplate(dataSource);

		account = jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_BY_EMAIL,
			new Object[]{email},
			new AccountResultSetExtractor());

		logger.debug("EXITING getAccountByEmail with account: " + account);

		return account;
	}

	@Override
	public final List<Account> getAccountList() throws SQLException {

		logger.debug("ENTERED getAccountList");

		final List<Account> accountsList;
		jdbcTemplate = new JdbcTemplate(dataSource);

		accountsList = new ArrayList<>(jdbcTemplate.query(PropertiesConfig.GET_ACCOUNT_LIST,
			new AccountListResultSetExtractor()));

		logger.debug("EXITING getAccountList");

		return accountsList;
	}

	@Override
	public void addAccount(final Account account) throws SQLException {

		logger.debug("ENTERED addAccount for account: " + account);

		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(PropertiesConfig.ADD_ACCOUNT,
			account.getId(),
			account.getUsername(),
			account.getPassword(),
			account.getEmail(),
			Instant.now().getEpochSecond()); // Set current timestamp as join date

		logger.debug("EXITING addAccount for account: " + account);
	}


	@Override
	public void updateAccount(final Account account) throws SQLException {

		logger.debug("ENTERED updateAccount for account: " + account);

		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(PropertiesConfig.EDIT_ACCOUNT,
			account.getUsername(),
			account.getPassword(),
			account.getEmail(),
		 	account.getId());

		logger.debug("EXITING updateAccount: " + account);
	}

	private static final class AccountResultSetExtractor implements ResultSetExtractor<Account> {

		@Override
		public Account extractData(final ResultSet resultSet) throws SQLException {

			final Account account;

			if (resultSet.next()) {
				account = new AccountBuilder()
					.withId(resultSet.getLong("id"))
					.withUsername(resultSet.getString("username"))
					.withPassword(resultSet.getString("password"))
					.withEmail(resultSet.getString("email"))
					.withJoinDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("join_date"),
						0, ZoneOffset.UTC))
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
					.withId(resultSet.getLong("accountId"))
					.withEmail(resultSet.getString("email"))
					.withJoinDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("join_date"),
						0, ZoneOffset.UTC))
					.build());
			}

			return accountList;
		}
	}
}
