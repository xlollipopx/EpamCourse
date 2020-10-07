import com.epam.task.five.data.FileStringAcquirer;
import com.epam.task.five.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class StringAcquirerTester {

    private static final String TEST_FILE = "src/test/java/resources/input1.txt";

    @Test
    public void testFileStringAcquirer() throws DataException {
        //given
        FileStringAcquirer fileStringAcquirer = new FileStringAcquirer(TEST_FILE);
        String actualString = fileStringAcquirer.readString();
        //when
        String expectedString = "pa ap rqepa";
        //then
        Assert.assertEquals(expectedString, actualString);
    }


}

