package com.epam.web.logic;

import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Beat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class HomeCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }
}
