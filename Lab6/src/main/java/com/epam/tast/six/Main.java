package com.epam.tast.six;
import com.epam.tast.six.dao.BookDao;
import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.model.Book;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Sun", "Bob", 1890, 15);
        Book bookTwo = new Book("Worm", "Ann", 1990, 12);
        Book bookThree = new Book("Sun", "Bob", 1490, 11);
        BookDao bookDao = new BookDao();
        bookDao.addBook(bookOne);
        bookDao.addBook(bookTwo);
        bookDao.addBook(bookThree);
        System.out.println(bookDao.findByTeg(BookFieldType.COST, 11));
        System.out.println(bookDao.sortByTeg(BookFieldType.AUTHOR_NAME));
    }

}
