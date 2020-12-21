package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAdminCatalogCommand implements Command {

    private static final BeatDao dao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {
        CatalogService service = new CatalogService();
        service.paginate(request, response, dao);
        return "WEB-INF/admin-catalog.jsp";
    }
}
