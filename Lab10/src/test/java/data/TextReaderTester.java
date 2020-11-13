package data;

import data.TextReader;
import data.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class TextReaderTester {
    private static final  TextReader TEXT_READER = new TextReader();
    private static final String FILE_NAME = "src/test/java/resources/inputOne.txt";
    private static final String WRONG_FILE_NAME = "src/test/java/resources/inputOe.txt";

    @Test
    public void testReadShouldReadDataWhenFileIsValid() throws DataException {
        //given
        String actual = TEXT_READER.read(FILE_NAME);
        //when
        String expected = "abcd ab\n";
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionWhenFileDoesNotExist() throws DataException {
        String actual = TEXT_READER.read(WRONG_FILE_NAME);
    }

}
