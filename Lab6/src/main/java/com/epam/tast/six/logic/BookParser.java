package com.epam.tast.six.logic;

import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.model.Book;

public class BookParser {
    private final static String LINE_SEPARATOR = "\\s+";
    private final static String IS_NUMBER_REGEX = "[-+]?\\d+";

    public Book parse(String line) throws DataException {
        String[] bookFields = line.split(LINE_SEPARATOR);
        if(!bookFields[2].matches(IS_NUMBER_REGEX)) {
            throw new DataException(bookFields[2] + "is not a number!");
        }

        if( !bookFields[3].matches(IS_NUMBER_REGEX)) {
            throw new DataException(bookFields[3] + "is not a number!");
        }
        return new Book(bookFields[0], bookFields[1],
                Integer.parseInt(bookFields[2]), Integer.parseInt(bookFields[3]));
    }
}
