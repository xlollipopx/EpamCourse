import com.epam.task.nine.data.DataException;
import com.epam.task.nine.data.FileDataReader;
import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTester {
    private static final String VALID_INPUT = "src/test/java/resources/inputOne.json";
    private static final String INVALID_INPUT = "src/test/java/resources/inputTwo.json";

    private final FileDataReader reader = new FileDataReader();

    @Test
    public void testReadShouldReturnStringWhenFileExists() throws DataException {
        //given
        String expected = "{  \"customers\": [    {      \"name\": \"Tom\",   " +
                "   \"order\": [        \"BURGER\",        \"TEA\"      ]    },    {      \"name\": \"Dom\",    " +
                "  \"order\": [        \"COFFEE\",        \"TEA\"      ]    }  ]}";
        //when
        String actual = reader.read(VALID_INPUT);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class) //then
    public void testReadShouldThrowExceptionWhenFileNotExists() throws DataException {
        //when
        reader.read(INVALID_INPUT);
    }
}
