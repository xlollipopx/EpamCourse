package logic;

public class FunctionCalculator {

    public double calculate(double x) {
        if(x >= 3) {
            return -x * x + 3 * x + 9;
        }
        else {
            return 1 / (Math.pow(x, 3) - 6);
        }
    }

}
