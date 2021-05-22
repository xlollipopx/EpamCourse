package data;

import com.epam.task.seven.data.validation.PyramidValidator;
import com.epam.task.seven.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PyramidValidatorTester {

    private final static Point POINT_ONE = new Point(0, 0 ,0);
    private final static Point POINT_TWO = new Point(1, 0 ,0);
    private final static Point POINT_THREE = new Point(0, 1 ,0);
    private final static Point POINT_FOUR = new Point(1, 1 ,0);
    private final static Point POINT_FIVE = new Point(1, 1 ,2);
    @Test
    public void testIsValidShouldReturnFalseWhenPointsLieInOnePlane() {
        //given
        List<Point> pointList = new LinkedList<>();
        pointList.add(POINT_ONE);
        pointList.add(POINT_TWO);
        pointList.add(POINT_THREE);
        pointList.add(POINT_FOUR);
        //when
        PyramidValidator pyramidValidator = new PyramidValidator();
        //then
        Assert.assertFalse(pyramidValidator.isValid(pointList));
    }

    @Test
    public void testIsValidShouldReturnTrueWhenPyramidIsValid() {
        //given
        List<Point> pointList = new LinkedList<>();
        pointList.add(POINT_ONE);
        pointList.add(POINT_TWO);
        pointList.add(POINT_THREE);
        pointList.add(POINT_FIVE);
        //when
        PyramidValidator pyramidValidator = new PyramidValidator();
        //then
        Assert.assertTrue(pyramidValidator.isValid(pointList));
    }

}
