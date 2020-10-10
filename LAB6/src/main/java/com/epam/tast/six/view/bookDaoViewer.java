package com.epam.tast.six.view;

import com.epam.tast.six.dao.BookDao;

public class bookDaoViewer {
    
    public void view(BookDao bookDao) {
        System.out.println(bookDao.toString());
    }
}
