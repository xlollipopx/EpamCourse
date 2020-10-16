package com.epam.tast.six.logic.specification;

import com.epam.tast.six.model.Book;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class Specification {

    public <T> List<Book> find(LinkedHashSet<Book> books, T field) {
        List<Book> bookList = new LinkedList<>();
        for(Book book: books) {
           addBook(book, field, bookList);
        }
        return bookList;
    }

    abstract protected  <T>  void addBook(Book book, T field, List<Book> bookList);

}

