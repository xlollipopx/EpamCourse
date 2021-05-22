package logic;

import com.epam.task.seven.data.DataException;
import com.epam.task.seven.data.validation.PyramidValidator;
import com.epam.task.seven.logic.PyramidParametersCalculator;
import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PyramidCalculatorTester {
    private final static Point POINT_ONE = new Point(0, 0 ,0);
    private final static Point POINT_TWO = new Point(1, 0 ,0);
    private final static Point POINT_THREE = new Point(0, 1 ,0);
    private final static Point POINT_FOUR = new Point(0, 0 ,1);
    private final static Double DELTA = 0.01;
    @Test
    public void testCalculateVolumeShouldCalculateVolumeWhenInputIsCorrect() {
        //given
        List<Point> pointList = new LinkedList<>();
        pointList.add(POINT_ONE);
        pointList.add(POINT_TWO);
        pointList.add(POINT_THREE);
        pointList.add(POINT_FOUR);
        Pyramid pyramid = new Pyramid(pointList);
        PyramidParametersCalculator pyramidParametersCalculator = new PyramidParametersCalculator();
        double actualVolume = pyramidParametersCalculator.calculateVolume(pyramid);
        //when
        double expectedVolume = 0.16667;
        //then
        Assert.assertEquals(actualVolume, expectedVolume, DELTA);
    }

    @Test
    public void testCalculateSurfaceAreaShouldCalculateSurfaceWhenInputIsCorrect()  {
        //given
        List<Point> pointList = new LinkedList<>();
        pointList.add(POINT_ONE);
        pointList.add(POINT_TWO);
        pointList.add(POINT_THREE);
        pointList.add(POINT_FOUR);
        Pyramid pyramid = new Pyramid(pointList);
        PyramidParametersCalculator pyramidParametersCalculator = new PyramidParametersCalculator();
        double actualArea = pyramidParametersCalculator.calculateSurfaceArea(pyramid);
        //when
        double expectedArea = 3;
        //then
        Assert.assertEquals(actualArea, expectedArea, DELTA);
    }

}
