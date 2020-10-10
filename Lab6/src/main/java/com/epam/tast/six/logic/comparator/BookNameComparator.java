package com.epam.tast.six.logic.comparator;

import com.epam.tast.six.model.Book;

import java.util.Comparator;

public class BookNameComparator implements Comparator<Book> {

    @Override
    public int compare(Book bookOne, Book bookTwo) {
        return bookOne.getBookName().compareTo(bookTwo.getBookName());
    }
}

