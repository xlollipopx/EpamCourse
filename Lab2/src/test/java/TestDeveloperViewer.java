import com.epam.task.second.data.*;
import com.epam.task.second.logic.SoftwareDeveloper;
import org.junit.Assert;
import org.junit.Test;

public class TestDeveloperViewer {


    final String TEXTFILE = "C:\\Users\\USER\\Desktop\\EPAM\\Lab2\\src\\main\\resources\\TestDeadlineCalculatorFile1.txt";
    final int DAYS = 10;
    SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper("Nick", DAYS);
    @Test
    public void testIfDateIsRight() {
        //given
        String expected = softwareDeveloper.toString();
        //when
        String testValue1 = FileStringReader.readString(TEXTFILE);
        //then
        Assert.assertEquals(expected, testValue1);
    }


}
