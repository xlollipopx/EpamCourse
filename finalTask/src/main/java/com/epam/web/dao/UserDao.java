package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;

import java.util.Optional;

public interface UserDao extends Dao<Account>{

    Optional<Account> findUserByLoginAndPassword(String login, String password) throws DaoException;

}
