package logic;

import logic.expression.calculator.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTester {
    private static final String VALUE_ONE = "[1_2_+_3_*_]";
    private static  final ExpressionCalculator EXPRESSION_CALCULATOR = new ExpressionCalculator(VALUE_ONE);

    @Test
    public void testCalculateShouldCalculateWhenDataIsValid() {
        //given
        Integer actual = (Integer) EXPRESSION_CALCULATOR.calculate();
        //when
        Integer expected = 9;
        //then
        Assert.assertEquals(actual,expected);
    }
    
}
