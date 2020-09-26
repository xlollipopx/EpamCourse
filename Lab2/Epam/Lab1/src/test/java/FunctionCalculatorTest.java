import data.AcquirerFactory;
import data.ConsoleAcquirerFactory;
import data.DataAcquirer;
import logic.FunctionCalculator;
import org.junit.Assert;
import org.junit.Test;


public class FunctionCalculatorTest {

    @Test
    public void testValueFunctionWhenArgumentIsMoreThenThree() {
        FunctionCalculator functionCalculator = new FunctionCalculator();
        double actual = functionCalculator.calculate(4);
        Assert.assertEquals((double)5,actual, 0);
    }

    @Test
    public void testValueFunctionWhenArgumentIsLessThenThree() {

        FunctionCalculator functionCalculator = new FunctionCalculator();
        double actual = functionCalculator.calculate(2);
        Assert.assertEquals(0.5, actual, 0);

    }

}
