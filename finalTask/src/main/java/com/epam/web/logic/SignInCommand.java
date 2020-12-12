package com.epam.web.logic;

import com.epam.web.model.PagePath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PagePath.SIGN_IN_PAGE;
    }
}
