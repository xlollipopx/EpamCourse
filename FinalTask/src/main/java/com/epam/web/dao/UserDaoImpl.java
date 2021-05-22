package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.mapper.UserRowMapper;
import com.epam.web.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<Account> implements UserDao {


    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM accounts" +
            " WHERE user_name = ? AND password = ?";
    private static final String FIND_BY_ID = "SELECT * FROM accounts WHERE account_id = ?";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Account> findUserByLoginAndPassword
            (String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD,
                new UserRowMapper(), login, password);
    }

    @Override
    public Optional<Account> getById(int id) throws DaoException {
        return executeForSingleResult(FIND_BY_ID,
                new UserRowMapper(),id);
    }

    @Override
    public List<Account> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public boolean save(Account item) {
        return save(item);
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    protected void extract(Account item, PreparedStatement preparedStatement) {

    }

    @Override
    protected String getSaveQuery() {
        return null;
    }

    @Override
    protected String getTableName() {
        return "accounts";
    }
}
