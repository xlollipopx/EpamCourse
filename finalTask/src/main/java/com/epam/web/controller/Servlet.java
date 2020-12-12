package com.epam.web.controller;

import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.logic.Command;
import com.epam.web.logic.CommandFactory;
import com.epam.web.model.Beat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        String commandParam = req.getParameter("command");
//        BeatDao beatDao = new BeatDaoImpl();
//         Beat beat = new Beat((long) 1, "Svm", "VPN", "2:10");
//         List<Beat> beats = beatDao.getAll();
//         beats.add(beat);
//         req.setAttribute("beats", beats);
            try {
                Command command = CommandFactory.create(commandParam);
                String page = command.execute(req, resp);
                dispatch(page, req, resp);
            } catch (ServletException | IOException | DaoException e) {
                e.printStackTrace();
            }


    }

    private void dispatch(final String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page).forward(req, resp);
    }

}
