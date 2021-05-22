package data;

import com.epam.task.seven.data.PyramidRepository;
import com.epam.task.seven.data.specification.PyramidIdSpecification;
import com.epam.task.seven.data.specification.PyramidVolumeInRangeSpecification;
import com.epam.task.seven.data.specification.Specification;
import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SpecificationsTester {
    private final static Point POINT_ONE = new Point(0, 0 ,0);
    private final static Point POINT_TWO = new Point(1, 0 ,0);
    private final static Point POINT_THREE = new Point(0, 1 ,0);
    private final static Point POINT_FOUR = new Point(0, 0 ,1);
    private final static Point POINT_FIVE = new Point(1, 1 ,2);
    private final static Point POINT_SIX = new Point(2, 3 ,4);
    private static final Pyramid PYRAMID_ONE = new Pyramid(POINT_ONE, POINT_TWO, POINT_THREE, POINT_FOUR);
    private static final Pyramid PYRAMID_TWO = new Pyramid(POINT_SIX, POINT_FIVE, POINT_THREE, POINT_FOUR);
    private static final Pyramid PYRAMID_THREE = new Pyramid(POINT_ONE, POINT_TWO, POINT_SIX, POINT_FOUR);
    private static final  int ID = 1;
    @Test
    public void testIdSpecificationShouldReturnListWhenIdIsGiven() {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        pyramidRepository.add(PYRAMID_TWO);
        pyramidRepository.add(PYRAMID_THREE);
        Specification<Pyramid> specification = new PyramidIdSpecification(ID);
        List<Pyramid> actualPyramidList = pyramidRepository.query(specification);
        //expected
        List<Pyramid> expectedListPyramid = new LinkedList<>();
        expectedListPyramid.add(PYRAMID_TWO);
        Assert.assertArrayEquals(actualPyramidList.toArray(), expectedListPyramid.toArray());
    }

    @Test
    public void testVolumeSpecificationShouldReturnList() {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        pyramidRepository.add(PYRAMID_TWO);
        pyramidRepository.add(PYRAMID_THREE);
        Specification<Pyramid> specification = new PyramidVolumeInRangeSpecification(0.16, 0.167);
        List<Pyramid> actualPyramidList = pyramidRepository.query(specification);
        //expected
        List<Pyramid> expectedListPyramid = new LinkedList<>();
        expectedListPyramid.add(PYRAMID_ONE);
        Assert.assertArrayEquals(actualPyramidList.toArray(), expectedListPyramid.toArray());
    }

}
