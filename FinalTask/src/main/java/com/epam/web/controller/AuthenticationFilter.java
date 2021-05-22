package com.epam.web.controller;



import com.epam.web.model.Account;
import com.epam.web.model.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private static final String TO_AUTHORIZED_HOME_COMMAND = "to-authorized-home";
    private static final String LOG_OUT_COMMAND = "log-out";
    private static final String ADD_BEAT_COMMAND = "add-beat";
    private static final String VIEW_BEATS_TO_ADMIN_COMMAND = "view-beats-to-admin";
    //private static final String LOGIN_COMMAND = "login";
    private static final String VIEW_BEATS_TO_CUSTOMER_COMMAND = "view-beats-to-customer";

    List<String> notVisitorCommands;
    List<String> notCustomerCommands;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String URI = request.getParameter("command");
        boolean flag = false;
        for (String command : notVisitorCommands) {
            if (URI != null && session.getAttribute("account") == null && URI.contains(command)){
                req.getRequestDispatcher("WEB-INF/sign-in-page.jsp").forward(req, resp);
                flag = true;
            }
        }
        for(String command: notCustomerCommands) {
            if (URI != null && session.getAttribute("account") != null && URI.contains(command)
            && ((Account)session.getAttribute("account")).getRole() != Role.ADMINISTRATOR) {
                req.getRequestDispatcher("WEB_INF/catalog.jsp").forward(req, resp);
                flag = true;
            }
        }
        if(!flag) {
            chain.doFilter(req, resp);
        }
    }
    public void init(FilterConfig config) throws ServletException {
        notVisitorCommands = new ArrayList<>();
        notCustomerCommands = new ArrayList<>();

        notVisitorCommands.add(TO_AUTHORIZED_HOME_COMMAND);
        notVisitorCommands.add(LOG_OUT_COMMAND);
        notVisitorCommands.add(ADD_BEAT_COMMAND);
        notVisitorCommands.add(VIEW_BEATS_TO_ADMIN_COMMAND);
        notVisitorCommands.add(VIEW_BEATS_TO_CUSTOMER_COMMAND);
       // notVisitorCommands.add(LOGIN_COMMAND);

        notCustomerCommands.add(ADD_BEAT_COMMAND);
        notCustomerCommands.add(VIEW_BEATS_TO_ADMIN_COMMAND);
    }

}