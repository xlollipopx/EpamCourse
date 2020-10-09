import com.epam.tast.six.dao.BookDao;
import com.epam.tast.six.data.FileBooksCreator;
import com.epam.tast.six.exception.DataException;
import com.epam.tast.six.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileBooksCreatorTester {

    private static final String TEST_FILE_ONE = "src/test/java/resources/inputOne.txt";
    private static final String TEST_FILE_TWO = "src/test/java/resources/inputTwo.txt";

    @Test(expected = DataException.class)
    public void testFileBooksCreatorShouldThrowException() throws DataException {

        FileBooksCreator fileBooksCreator = new FileBooksCreator(TEST_FILE_ONE);
        fileBooksCreator.create();
    }

    @Test
    public void testFileBooksCreatorShouldCreate() throws DataException {
        //given
        FileBooksCreator fileBooksCreator = new FileBooksCreator(TEST_FILE_TWO);
        List<Book> actualBookList = fileBooksCreator.create();
        //when
        Book[] expectedBookList = {new Book("Rise", "Dan", 1590, 50)};
        //then
        Assert.assertArrayEquals(actualBookList.toArray(), expectedBookList);
    }

}
