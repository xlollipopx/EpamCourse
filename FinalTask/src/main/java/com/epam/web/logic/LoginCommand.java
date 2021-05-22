package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.UserDao;
import com.epam.web.dao.UserDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Role;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginService service = new LoginService();
        boolean valid = service.login(login, password);
        UserDao dao = new UserDaoImpl(ConnectionPool.getInstance().getConnection());

            Optional<Account> acc = dao.findUserByLoginAndPassword(login, password);
            if(acc.isPresent()) {
                Account account = acc.get();
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                return "WEB-INF/authorized-home.jsp";

            } else {
                return "WEB-INF/wrong-login.jsp";
            }

    }
}

