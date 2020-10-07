import com.epam.task.five.logic.StringProcessorByCharSequence;
import com.epam.task.five.logic.StringProcessorByRegularExpressions;
import com.epam.task.five.logic.StringProcessorByStringMethods;
import org.junit.Assert;
import org.junit.Test;

public class StringProcessorTester {
    private static final String TEST_STRING = "pa fvpajfnv pa";

    @Test
    public void testStringProcessorByStringMethods() {
        //given
        StringProcessorByStringMethods stringProcessorByStringMethods = new StringProcessorByStringMethods();
        String actualString = stringProcessorByStringMethods.fixString(TEST_STRING);
        //when
        String expectedString = "po fvpojfnv po";
        //then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testStringProcessorByCharSequence() {
        //given
        StringProcessorByCharSequence stringProcessorByCharSequence = new StringProcessorByCharSequence();
        String actualString = stringProcessorByCharSequence.fixString(TEST_STRING);
        //when
        String expectedString = "po fvpojfnv po";
        //then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testStringProcessorByRegularExpression() {
        //given
        StringProcessorByRegularExpressions stringProcessorByRegularExpressions = new StringProcessorByRegularExpressions();
        String actualString = stringProcessorByRegularExpressions.fixString(TEST_STRING);
        //when
        String expectedString = "po fvpojfnv po";
        //then
        Assert.assertEquals(expectedString, actualString);
    }
}
