package com.epam.tast.six;
import com.epam.tast.six.dao.BookDao;
import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.data.FileBooksCreator;
import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.model.Book;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class);

    private final static String FILE_NAME = "input.txt";

    public static void main(String[] args) {

        try {
            run();
        } catch (DataException e) {
           LOGGER.error(e.getMessage(),e);
        }
    }

    public static void run() throws DataException {
        LOGGER.info("Main started");
        FileBooksCreator fileBooksCreator = new FileBooksCreator(FILE_NAME);
        BookDao bookDao = new BookDao();
        LOGGER.info("bookDao has been created");

        bookDao.addBook(
                fileBooksCreator.create());

        LOGGER.info("Books have been added to bookDao");
        List<Book> bookList = bookDao.findByTeg(
                BookFieldType.COST, 11);

        LOGGER.info("find by teg result:" + bookList);
        List<Book> bookListTwo = bookDao.sortByTeg(
                BookFieldType.PUBLICATION_YEAR);

        LOGGER.info("sort result: " + bookListTwo);

    }

}
