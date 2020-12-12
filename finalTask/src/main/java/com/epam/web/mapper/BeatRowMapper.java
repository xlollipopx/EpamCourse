package com.epam.web.mapper;

import com.epam.web.model.Account;
import com.epam.web.model.Beat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeatRowMapper implements RowMapper{
    @Override
    public Beat map(ResultSet resultSet) throws SQLException {
        int beatId = resultSet.getInt("beat_id");
        String name = resultSet.getString("name");
        String timing = resultSet.getString("timing");
        String imagePath = resultSet.getString("image_path");

        return new Beat(beatId, name, timing, imagePath);
    }
}
