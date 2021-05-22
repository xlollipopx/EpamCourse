package com.epam.web.mapper;

import com.epam.web.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<Account> {
    @Override
    public Account map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("account_id");
        String name = resultSet.getString("user_name");
        String password = resultSet.getString("password");
        int roleId = resultSet.getInt("role_id");
        return new Account(id, name, password, roleId);
    }
}
