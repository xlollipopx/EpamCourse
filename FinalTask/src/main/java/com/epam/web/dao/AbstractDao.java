package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.extractor.BeatFieldsExtractor;
import com.epam.web.extractor.FieldsExtractor;
import com.epam.web.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T>{
    private Connection connection;

    protected AbstractDao(Connection connection) {
        this.connection = connection;
    }

    protected List<T> executeQuery(String query, RowMapper<T> mapper, Object ... params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params);
        ResultSet resultSet = statement.executeQuery()) {
            List<T> entities = new ArrayList<>();
            while(resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException();
        }
    }


    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for(int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    protected Optional<T> executeForSingleResult(String query, RowMapper<T> mapper, Object ... params) throws DaoException {
        List<T> items = executeQuery(query, mapper, params);
        if(items.size() == 1) {
            return Optional.of(items.get(0));
        } else if(items.size() > 1) {
            throw new IllegalArgumentException("More the one record found");
        } else {
            return Optional.empty();
        }

    }


    @Override
    public Optional getById(int id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery("select * from " + table, mapper);
    }

    @Override
    public boolean save(T item) {
        boolean result;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getSaveQuery());
            extract(item, preparedStatement);
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException sql) {
            return false;
        }
        return result;
    }

    @Override
    public void removeById(Long id) {

    }

    protected abstract void extract(T item, PreparedStatement preparedStatement);

    protected abstract String getSaveQuery();

    protected abstract String getTableName();
}
