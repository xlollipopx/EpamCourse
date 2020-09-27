import data.FileDataAcquirer;
import logic.CostCalculator;
import model.Squad;
import org.junit.Assert;
import org.junit.Test;

public class CostCalculatorTester {

    private FileDataAcquirer fileDataAcquirer = new FileDataAcquirer();
    private final double DELTA = 0.001;
    CostCalculator costCalculator = new CostCalculator();
    private final String FILE = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\main\\java\\data\\resources\\input.txt";
    private final String FILE1 = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\test\\java\\resources\\input1.txt";
    @Test
    public void testCostCalculator() {
        //given
        Squad squad = new Squad(fileDataAcquirer.readWeaponList(FILE));
        CostCalculator costCalculator = new CostCalculator();
        int cost = costCalculator.calculate(squad);
        //when
        int expectedCost = Integer.parseInt(fileDataAcquirer.read(FILE1));
        //then
        Assert.assertEquals(expectedCost, cost, DELTA);
    }

}
