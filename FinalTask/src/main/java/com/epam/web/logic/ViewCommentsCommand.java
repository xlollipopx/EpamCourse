package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.dao.CommentsDaoImpl;
import com.epam.web.dao.UserDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;
import com.epam.web.model.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ViewCommentsCommand  implements Command{

    private static final CommentsDaoImpl COMMENTS_DAO = new CommentsDaoImpl(ConnectionPool.getInstance().getConnection());
    private static final BeatDaoImpl BEAT_DAO = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());
    private static final UserDaoImpl USER_DAO = new UserDaoImpl(ConnectionPool.getInstance().getConnection());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        String stringBeatId = request.getParameter("beatId");

        int beatId = Integer.parseInt(stringBeatId);
        Optional<Beat> beatOpt = BEAT_DAO.getById(beatId);
        if(beatOpt.isPresent()){
            Beat beat = beatOpt.get();
            request.setAttribute("currentBeat", beat);
        }

        List<Comment> comments = COMMENTS_DAO.findCommentsForCurrentBeat(beatId);

        for(Comment comment: comments) {
            int aid = comment.getAccountId();
            Optional accountOpt = USER_DAO.getById(aid);
            if(accountOpt.isPresent()) {
               Account account = (Account)accountOpt.get();
               comment.setAuthorName(account.getName());
            }
        }

        request.setAttribute("comments", comments);
        request.setAttribute("beatId", beatId);

        return "WEB-INF/comments.jsp";
    }
}
