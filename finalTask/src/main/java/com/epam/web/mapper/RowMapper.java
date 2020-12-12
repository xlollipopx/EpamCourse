package com.epam.web.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<?> create(String table) {
        switch(table) {
            case "accounts":
                return new UserRowMapper();
            case "beats":
                return new BeatRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table = " + table);
        }
    }
}
