package data;

import com.epam.task.seven.data.validation.PyramidInputValidator;
import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTester {

    private static final String TEST_STRING_ONE = "1 1 1  2 2 1  1o 1 1  4 4 4 ";
    private static final String TEST_STRING_TWO = "1 1 1  2 2 1  1 1 1  4 4 4";
    @Test
    public void testIsValidShouldReturnFalseWhenInputIsWrong() {
        //given
        PyramidInputValidator pyramidInputValidator = new PyramidInputValidator();
        boolean result = pyramidInputValidator.isValid(TEST_STRING_ONE);
        //when
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsValidShouldReturnTrueWhenInputIsValid() {
        //given
        PyramidInputValidator pyramidInputValidator = new PyramidInputValidator();
        boolean result = pyramidInputValidator.isValid(TEST_STRING_TWO);
        //when
        //then
        Assert.assertTrue(result);
    }
}

