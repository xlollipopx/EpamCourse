package com.epam.tast.six.dao;

import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.model.Book;

import java.util.List;

public interface Dao {

    void addBook(Book book);
    void removeBook(Book book);
    <T> List<Book> findByTeg(BookFieldType bookFieldType, T teg);

}
