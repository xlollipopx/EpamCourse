package logic;

import logic.ExpressionValidator;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionValidatorTester {

    private static final  ExpressionValidator EXPRESSION_VALIDATOR = new ExpressionValidator();

    @Test
    public void testValidateShouldReturnTrueWhenExpressionIsValid() {
        //given
        String actual = "[1_2_+_]";
        //then
        Assert.assertTrue(EXPRESSION_VALIDATOR.validate(actual));
    }

    @Test
    public void testValidateShouldReturnFalseWhenExpressionIsInvalid() {
        //given
        String actual = "1_2vv]";
        //then
        Assert.assertFalse(EXPRESSION_VALIDATOR.validate(actual));

    }


}
