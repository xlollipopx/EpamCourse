package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Beat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CatalogCommand implements Command{

    private static final BeatDao dao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        CatalogService service = new CatalogService();
        service.paginate(request, response, dao);
        return "WEB-INF/catalog.jsp";
    }
}
