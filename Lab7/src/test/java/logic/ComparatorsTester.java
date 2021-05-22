package logic;

import com.epam.task.seven.data.PyramidRepository;
import com.epam.task.seven.logic.comparator.PyramidSurfaceAreaComparator;
import com.epam.task.seven.logic.comparator.PyramidVolumeComparator;
import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparatorsTester {
    private final static Point POINT_ONE = new Point(0, 0 ,0);
    private final static Point POINT_TWO = new Point(1, 0 ,0);
    private final static Point POINT_THREE = new Point(0, 1 ,0);
    private final static Point POINT_FOUR = new Point(0, 0 ,1);
    private final static Point POINT_FIVE = new Point(0, 0 ,2);
    private final static Point POINT_SIX = new Point(0, 2 ,0);
    private final static Point POINT_SEVEN = new Point(2, 0 ,0);
    private final static Point POINT_EIGHT = new Point(3, 0 ,0);
    private final static Point POINT_NINE = new Point(0, 3 ,0);
    private final static Point POINT_TEN = new Point(0, 0 ,3);
    private static final Pyramid PYRAMID_ONE = new Pyramid(POINT_ONE, POINT_TWO, POINT_THREE, POINT_FOUR);
    private static final Pyramid PYRAMID_TWO = new Pyramid(POINT_ONE, POINT_FIVE, POINT_SIX, POINT_SEVEN);
    private static final Pyramid PYRAMID_THREE = new Pyramid(POINT_ONE, POINT_EIGHT, POINT_NINE, POINT_TEN);

    @Test
    public void testVolumeComparatorShouldSortByVolumeWhenDataIsValid() {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_THREE);
        pyramidRepository.add(PYRAMID_TWO);
        pyramidRepository.add(PYRAMID_ONE);
        Comparator<Pyramid> comparator = new PyramidVolumeComparator();
        List<Pyramid>  actualList = pyramidRepository.sort(comparator);
        //when
        List<Pyramid> expectedList = new LinkedList<>();
        expectedList.add(PYRAMID_ONE);
        expectedList.add(PYRAMID_TWO);
        expectedList.add(PYRAMID_THREE);
        //then
        Assert.assertArrayEquals(expectedList.toArray(),actualList.toArray());
    }

    @Test
    public void testSurfaceAreaComparatorShouldSortByVolumeWhenDataIsValid() {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_THREE);
        pyramidRepository.add(PYRAMID_TWO);
        pyramidRepository.add(PYRAMID_ONE);
        Comparator<Pyramid> comparator = new PyramidSurfaceAreaComparator();
        List<Pyramid>  actualList = pyramidRepository.sort(comparator);
        //when
        List<Pyramid> expectedList = new LinkedList<>();
        expectedList.add(PYRAMID_ONE);
        expectedList.add(PYRAMID_TWO);
        expectedList.add(PYRAMID_THREE);
        //then
        Assert.assertArrayEquals(expectedList.toArray(),actualList.toArray());
    }
}
