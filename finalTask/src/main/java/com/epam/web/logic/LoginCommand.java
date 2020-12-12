package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.UserDao;
import com.epam.web.dao.UserDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginService service = new LoginService();
        boolean valid = service.login(login, password);
        UserDao dao = new UserDaoImpl(ConnectionPool.getInstance().getConnection());

        try {
            Optional<Account> acc = dao.findUserByLoginAndPassword(login, password);


        } catch (DaoException e) {
            e.printStackTrace();
        }



        if(true) {
            return "WEB-INF/view/main.jsp";
        }
        else {
           request.setAttribute("errorMessage", "invalid creds");
           return "pages/biba.jsp";
        }
    }
}

