package com.epam.web.logic;

import com.epam.web.dao.BeatDao;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Beat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CatalogService {

    public void paginate(HttpServletRequest request, HttpServletResponse response, BeatDao dao) {
        List<Beat> products = null;
        try {
            products = dao.getAll();
            int page = 1;
            int recordsPerPage = 4;
            if(request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            List<Beat> listPerPage = new ArrayList<>();
            for(int i = (page - 1) * recordsPerPage; i <(page-1) * recordsPerPage + recordsPerPage; i++) {
                if(i < products.size()) {
                    listPerPage.add(products.get(i));
                }
            }

            int noOfRecords = products.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("beatList", listPerPage);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.setAttribute("products", products);
    }

}
