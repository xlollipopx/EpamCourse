package data;

import com.epam.task.seven.data.DataException;
import com.epam.task.seven.data.FileDataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileDataReaderTester {

    private static final String TEST_FILE_NAME = "src/test/java/resources/inputOne.txt";
    private static final String TEST_STRING_ONE = "1 2 3 42 4";
    @Test
    public void testReadShouldReadStringsWhenInputIsValid() throws DataException {
        //given
        FileDataReader fileDataReader = new FileDataReader(TEST_FILE_NAME);
        List<String> actualStrings = fileDataReader.read();
        //when
        List<String> expectedStrings = new LinkedList<>();
        expectedStrings.add(TEST_STRING_ONE);
        //then
        Assert.assertArrayEquals(expectedStrings.toArray(),actualStrings.toArray());

    }
}
