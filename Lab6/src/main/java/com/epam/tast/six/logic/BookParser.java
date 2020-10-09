package com.epam.tast.six.logic;

import com.epam.tast.six.model.Book;

public class BookParser {
    public Book parse(String line) {
        String[] bookFields = line.split(" ");
        return new Book(bookFields[0], bookFields[1],
                Integer.parseInt(bookFields[2]), Integer.parseInt(bookFields[3]));
    }

}
