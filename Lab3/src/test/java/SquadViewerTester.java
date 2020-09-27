import data.FileDataAcquirer;
import logic.CostCalculator;
import model.Blade;
import model.Squad;
import model.Weapon;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SquadViewerTester {
    private FileDataAcquirer fileDataAcquirer = new FileDataAcquirer();

    private final String FILE = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\main\\java\\data\\resources\\input.txt";
    private final String FILE2 = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\test\\java\\resources\\input2.txt";
    private final String FILE3 = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\test\\java\\resources\\input3.txt";
    @Test
    public void testSquadViewer() {
        //given
        List<Weapon> weapons = new LinkedList<Weapon>();
        weapons.add(new Blade("BLADE", 10, 60));
        Squad squad = new Squad(weapons);
        //when
        String expected = fileDataAcquirer.read(FILE2);
        //then
        Assert.assertEquals(squad.toString(), expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidData() {

        Squad squad = new Squad(fileDataAcquirer.readWeaponList(FILE3));

    }



}
