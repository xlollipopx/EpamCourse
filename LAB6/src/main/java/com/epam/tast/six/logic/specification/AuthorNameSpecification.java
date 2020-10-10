package com.epam.tast.six.logic.specification;

import com.epam.tast.six.model.Book;

import java.util.List;

public class AuthorNameSpecification extends Specification{

    @Override
    protected <T> void addBook(Book book, T field, List<Book> bookList) {
        if(book.getAuthorName().equals(field)) {
            bookList.add(book);
        }
    }
}
