package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.dao.CommentsDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;
import com.epam.web.model.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;


public class AddCommentCommand implements Command {

    private static final CommentsDaoImpl COMMENTS_DAO = new CommentsDaoImpl(ConnectionPool.getInstance().getConnection());
    private static final BeatDaoImpl BEAT_DAO = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {

        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");

        int beatId =  Integer.parseInt(request.getParameter("beatId"));//
        String text = request.getParameter("commentText");
        Comment comment = new Comment(text, new Date(1000), account.getId(), beatId);
        COMMENTS_DAO.save(comment);


        return (new ViewCommentsCommand()).execute(request, response);
    }
}
