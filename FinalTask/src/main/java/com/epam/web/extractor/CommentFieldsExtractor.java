package com.epam.web.extractor;

import com.epam.web.model.Comment;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentFieldsExtractor implements FieldsExtractor<Comment>{

    @Override
    public void extract(Comment item, PreparedStatement statement) {
        try {
            statement.setInt(1, 0);
            statement.setString(2, item.getText());
            statement.setDate(3, item.getDate());
            statement.setInt(4, item.getAccountId());
            statement.setInt(5, item.getBeatId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
