package com.epam.tast.six.specification;

import com.epam.tast.six.model.Book;

import java.util.List;

public class CostSpecification  extends Specification{

    @Override
    protected <T> void addBook(Book book, T field, List<Book> bookList) {
        if (book.getCost() == (int) field) {
            bookList.add(book);
        }
    }

}
