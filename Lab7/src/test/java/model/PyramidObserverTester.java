package model;

import com.epam.task.seven.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PyramidObserverTester {
    private final static Point POINT_ONE = new Point(0, 0 ,0);
    private final static Point POINT_TWO = new Point(1, 0 ,0);
    private final static Point POINT_THREE = new Point(0, 1 ,0);
    private final static Point POINT_FOUR = new Point(0, 0 ,1);
    private final static Point POINT_FIVE = new Point(1, 1 ,2);
    private final static Point POINT_SIX = new Point(2, 3 ,4);
    private static final Pyramid PYRAMID_ONE = new Pyramid(POINT_ONE, POINT_TWO, POINT_THREE, POINT_FOUR);
    private static final Pyramid PYRAMID_TWO = new Pyramid(POINT_SIX, POINT_FIVE, POINT_THREE, POINT_FOUR);
    private static final Pyramid PYRAMID_THREE = new Pyramid(POINT_ONE, POINT_TWO, POINT_SIX, POINT_FOUR);
    private static final int IdZero = 0;
    private static final double DELTA = 0.001;
    @Test
    public void testNotifyShouldNotifyPyramidParametersWhenPyramidObjectChanged() {
        //given
        PyramidObservable pyramid = new PyramidObservable(POINT_ONE, POINT_TWO,POINT_THREE, POINT_FOUR);
        PyramidObserver pyramidObserver = PyramidObserver.getInstance();
        pyramid.addObserver(pyramidObserver);
        pyramid.setFirstPoint(POINT_SIX);
        Optional<Double> actualValue = pyramidObserver.getVolume(3);
        //when
        double expectedValue = 1.3333333333333333;
        //then
        Assert.assertEquals(actualValue, Optional.of(expectedValue));
    }
}
