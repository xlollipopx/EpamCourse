package com.epam.web.extractor;

import com.epam.web.model.Beat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BeatFieldsExtractor implements FieldsExtractor<Beat>{

    @Override
    public void extract(Beat item, PreparedStatement statement) {
        try {
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getTiming());
            statement.setString(4, item.getImagePath());
            if(item.getAlbumId() == 0) {
                statement.setNull(5, 0);
            }
            else {
                statement.setInt(5, item.getAlbumId());
            }

            statement.setInt(6, item.getAccountId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
