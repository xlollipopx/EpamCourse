import com.epam.tast.six.dao.BookDao;
import com.epam.tast.six.data.BookFieldType;
import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BookDaoTester {


    private Book bookOne = new Book("Sun", "Bob", 1890, 15);
    private Book bookTwo = new Book("Worm", "Ann", 1990, 12);
    private Book bookThree = new Book("Sun", "Bob", 1490, 11);
    @Test
    public void TestAddMethod() throws DataException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.addBook(new Book("Raf", "Dan", 1390, 100));
        int actualSize = bookDao.getSize();
        //when
        int expectedSize = 1;
        //then
        Assert.assertEquals(actualSize, expectedSize);
    }

    @Test
    public void TestRemoveMethod() throws DataException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.addBook(new Book("Raf", "Dan", 1390, 100));
        bookDao.removeBook(new Book("Raf", "Dan", 1390, 100));
        int actualSize = bookDao.getSize();
        //when
        int expectedSize = 0;
        //then
        Assert.assertEquals(actualSize, expectedSize);
    }

    @Test
    public void TestFindByTeg() throws DataException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.addBook(bookOne);
        bookDao.addBook(bookTwo);
        bookDao.addBook(bookThree);
        List<Book> actualList = bookDao.findByTeg(BookFieldType.AUTHOR_NAME, "Bob");
        //when
        Book[] expectedList = {bookOne, bookThree};
        //then
        Assert.assertArrayEquals(actualList.toArray(), expectedList);
    }

    @Test
    public void TestSortByTeg() throws DataException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.addBook(bookOne);
        bookDao.addBook(bookTwo);
        bookDao.addBook(bookThree);
        List<Book> actualList = bookDao.sortByTeg(BookFieldType.COST);
        //when
        Book[] expectedList = {bookThree, bookTwo, bookOne};
        //then
        Assert.assertArrayEquals(actualList.toArray(), expectedList);
    }






}
