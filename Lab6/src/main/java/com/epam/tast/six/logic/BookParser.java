package com.epam.tast.six.logic;

import com.epam.tast.six.model.Book;

public class BookParser {
    private final static String LINE_SEPARATOR = "\\s+";
    public Book parse(String line) {

        String[] bookFields = line.split(LINE_SEPARATOR);
        return new Book(bookFields[0], bookFields[1],
                Integer.parseInt(bookFields[2]), Integer.parseInt(bookFields[3]));
    }

}
