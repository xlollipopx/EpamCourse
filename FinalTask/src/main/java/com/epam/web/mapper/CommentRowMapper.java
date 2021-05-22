package com.epam.web.mapper;

import com.epam.web.model.Comment;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment map(ResultSet resultSet) throws SQLException {
        int commentId = resultSet.getInt("comment_id");
        String text = resultSet.getString("text");
        Date date = resultSet.getDate("date");
        int accountId = resultSet.getInt("account_id");
        int beat_id = resultSet.getInt("beat_id");
        return new Comment(commentId, text, date, accountId, beat_id);

    }
}
