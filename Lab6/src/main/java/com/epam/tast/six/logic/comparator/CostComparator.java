package com.epam.tast.six.logic.comparator;

import com.epam.tast.six.model.Book;

import java.util.Comparator;

public class CostComparator implements Comparator<Book> {
    @Override
    public int compare(Book bookOne, Book bookTwo) {
        return bookOne.getCost() - bookTwo.getCost();
    }
}

