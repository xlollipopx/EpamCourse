
import data.AcquirerFactory;
import data.ConsoleAcquirerFactory;
import data.ConsoleDataAcquirer;
import data.DataAcquirer;
import logic.FunctionCalculator;
import view.ValueViewer;

public class Main {

    public static void main(String[] args) {
        //receive
        AcquirerFactory acquirerFactory = new ConsoleAcquirerFactory();
        DataAcquirer dataAcquirer = acquirerFactory.createDataAcquirer();
        double x = dataAcquirer.GetNumber();
        //calculate
        FunctionCalculator functionCalculator = new FunctionCalculator();
        double result = functionCalculator.calculate(x);
        //view
        ValueViewer valueViewer = new ValueViewer();
        valueViewer.viewFunctionValue(result);
    }
}
