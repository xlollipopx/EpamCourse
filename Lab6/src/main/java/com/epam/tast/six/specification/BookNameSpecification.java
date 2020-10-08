package com.epam.tast.six.specification;

import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.model.Book;

import java.util.List;

public class BookNameSpecification extends Specification{

    @Override
    protected <T> void addBook(Book book, T field, List<Book> bookList) {
        if(book.getBookName().equals(field)) {
            bookList.add(book);
        }
    }
}
