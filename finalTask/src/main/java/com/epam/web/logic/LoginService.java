package com.epam.web.logic;

public class LoginService {

    public boolean login(String login, String password) {
        return "admin".equals(login) && "admin".equals(password);
    }
}
