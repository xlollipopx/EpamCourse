package com.epam.web.logic;

import com.epam.web.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetLocaleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {



return "hui";
     //   request.sendRedirect(getBackRedirectUrl(request), response);
    }
}
