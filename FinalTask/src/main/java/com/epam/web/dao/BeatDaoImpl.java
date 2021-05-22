package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.extractor.BeatFieldsExtractor;
import com.epam.web.extractor.FieldsExtractor;
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

    BeatFieldsExtractor beatFieldsExtractor = new BeatFieldsExtractor();
    private static final String FIND_BY_NAME = "select from beats where name = ?";
    private static final String SAVE = "INSERT INTO beats (beat_id, name, timing," +
            " image_path, albom_id, account_id) Values (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM beats WHERE beat_id = ?";
    public BeatDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Optional<Beat> getById(int id) throws DaoException {
        return executeForSingleResult(FIND_BY_ID,
                new BeatRowMapper(), id);
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

    public boolean save(Beat item) {
        return super.save(item);
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    protected void extract(Beat item, PreparedStatement preparedStatement) {
        beatFieldsExtractor.extract(item, preparedStatement);
    }

    @Override
    protected String getSaveQuery() {
        return SAVE;
    }

    @Override
    protected String getTableName() {
        return "beats";
    }


}
