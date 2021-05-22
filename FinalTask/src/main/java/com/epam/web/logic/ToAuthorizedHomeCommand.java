package com.epam.web.logic;

import com.epam.web.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToAuthorizedHomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        return "WEB-INF/authorized-home.jsp";
    }
}
