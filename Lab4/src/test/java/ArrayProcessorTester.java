
import com.epam.task.four.logic.ArrayProcessor;
import com.epam.task.four.model.Array;
import org.junit.Assert;
import org.junit.Test;

public class ArrayProcessorTester {

    private ArrayProcessor arrayProcessor = new ArrayProcessor();

    @Test
    public void testSortShouldSortArray() {
        //given
        Array array = new Array(5, 2, 4, 1, 3);
        arrayProcessor.sortArray(array);
        //when
        Array expectedArray = new Array(1, 2, 3, 4, 5);
        //then
        Assert.assertEquals(array, expectedArray);
    }

    @Test
    public void testFindMaxElement() {
        //given
        Array array = new Array(5, 2, 4, 1, 15, 12);
        int actualMax = arrayProcessor.findMaxElement(array);
        //when
        int expectedMax = 15;
        //then
        Assert.assertEquals(actualMax, expectedMax);
    }

    @Test
    public void testFindMinElement() {
        //given
        Array array = new Array(5, 2, 4, 1, 15, 12);
        int actualMin = arrayProcessor.findMinElement(array);
        //when
        int expectedMin = 1;
        //then
        Assert.assertEquals(actualMin, expectedMin);
    }


}
