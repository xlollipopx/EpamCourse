package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBeatCommand implements Command{

    private static final BeatDao beatDao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        String beatName = request.getParameter("beatName");
        String timing = request.getParameter("beatTiming");
        String imagePath = request.getParameter("imagePath");
        HttpSession session = request.getSession();
        Account account =  (Account)session.getAttribute("account");
        int accountId = account.getId();
        Beat beat = new Beat(beatName, timing, imagePath, 0, accountId);
        beatDao.save(beat);
        CatalogCommand catalogCommand = new CatalogCommand();
        return catalogCommand.execute(request, response);
    }
}
