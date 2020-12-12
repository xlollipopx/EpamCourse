package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.mapper.BeatRowMapper;
import com.epam.web.mapper.RowMapper;
import com.epam.web.mapper.UserRowMapper;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BeatDaoImpl extends AbstractDao<Beat> implements BeatDao {

    private static final String FIND_BY_NAME = "select from accounts where name = ?";
    public BeatDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Optional<Beat> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Beat> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public Optional<Beat> findBeatByName(String name) throws DaoException {
        return executeForSingleResult(FIND_BY_NAME,
                new BeatRowMapper(), name);
    }

    public void save(Account item) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    protected String getTableName() {
        return "beats";
    }


}
