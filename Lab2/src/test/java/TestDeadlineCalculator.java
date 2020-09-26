
import com.epam.task.second.data.FileStringReader;
import com.epam.task.second.logic.DeadlineCalculator;
import com.epam.task.second.logic.DeveloperCreator;
import com.epam.task.second.logic.SoftwareDeveloper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;


public class TestDeadlineCalculator {
    final double DELTA = 0.001;
    final int OFFSET1 = 5;
    Calendar calendar = Calendar.getInstance();
    SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper("A", OFFSET1);
    DeadlineCalculator deadlineCalculator = new DeadlineCalculator();

    @Test
    public void testIfDateIsRight() {
        //given
        calendar.add(Calendar.DAY_OF_MONTH, OFFSET1);
        //when
        String deadline = deadlineCalculator.countDeadLineDate(softwareDeveloper);
        //then
        Assert.assertEquals(deadline,calendar.getTime().toString());
    }

}
