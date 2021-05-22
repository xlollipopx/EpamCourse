package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.extractor.CommentFieldsExtractor;
import com.epam.web.mapper.CommentRowMapper;
import com.epam.web.mapper.RowMapper;
import com.epam.web.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CommentsDaoImpl extends AbstractDao<Comment> implements CommentsDao{

    CommentFieldsExtractor commentFieldsExtractor = new CommentFieldsExtractor();
    private static final String SAVE = "INSERT INTO comments (comment_id, text, date," +
            " account_id, beat_id) Values (?, ?, ?, ?, ?)";
    private static final String FIND_BY_BEAT_ID = "SELECT * FROM comments WHERE beat_id = ?";

    public CommentsDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected void extract(Comment item, PreparedStatement preparedStatement) {
        commentFieldsExtractor.extract(item, preparedStatement);
    }

    public List<Comment> findCommentsForCurrentBeat(int id) {

        CommentRowMapper mapper =  new CommentRowMapper();
        try {
            return executeQuery(FIND_BY_BEAT_ID, mapper, id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean save(Comment item) {
        return super.save(item);
    }

    @Override
    protected String getSaveQuery() {
        return SAVE;
    }

    @Override
    protected String getTableName() {
        return "comments";
    }
}
