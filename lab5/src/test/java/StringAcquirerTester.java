import com.epam.task.five.data.FileStringAcquirer;
import com.epam.task.five.exception.DataException;
import com.epam.task.five.logic.StringProcessorByCharSequence;
import com.epam.task.five.logic.StringProcessorByStringMethods;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class StringAcquirerTester {

    private static final String TEST_STRING = "src/test/java/resources/input1.txt";

    @Test
    public void testFileStringAcquirer() throws DataException {
        //given
        FileStringAcquirer fileStringAcquirer = new FileStringAcquirer(TEST_STRING);
        String actualString = fileStringAcquirer.readString();
        //when
        String expectedString = "pa ap rqepa";
        //then
        Assert.assertEquals(expectedString, actualString);
    }


}

