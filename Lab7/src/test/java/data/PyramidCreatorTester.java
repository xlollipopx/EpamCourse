package data;

import com.epam.task.seven.data.PyramidCreator;
import com.epam.task.seven.data.validation.InputValidator;
import com.epam.task.seven.data.validation.PyramidInputValidator;
import com.epam.task.seven.data.validation.PyramidValidator;
import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

public class PyramidCreatorTester {

    private static final String TEST_STRING_ONE = "1 1 1  2 12 10  11 41 1  40 7 8";
    private final static Point POINT_ONE = new Point(1, 1 ,1);
    private final static Point POINT_TWO = new Point(2, 12 ,10);
    private final static Point POINT_THREE = new Point(11, 41 ,1);
    private final static Point POINT_FOUR = new Point(40, 7 ,8);
    private static final int X_1 = 0;
    @Test
    public void testCreateShouldCreatePyramidsWhenInputIsValid() {
        //given
        List<String> strings = new LinkedList<>();
        strings.add(TEST_STRING_ONE);
        PyramidInputValidator pyramidInputValidator = Mockito.mock(PyramidInputValidator.class);
        Mockito.when(pyramidInputValidator.isValid(Mockito.anyString())).thenReturn(true);
        PyramidValidator pyramidValidator = Mockito.mock(PyramidValidator.class);
        Mockito.when(pyramidValidator.isValid(Mockito.any())).thenReturn(true);
        PyramidCreator pyramidCreator = new PyramidCreator();
        Pyramid actualPyramid = pyramidCreator.create(strings).get(X_1);
        //when
        Pyramid expectedPyramid = new Pyramid(POINT_ONE, POINT_TWO,
                POINT_THREE, POINT_FOUR);
        //then
        Assert.assertEquals(expectedPyramid, actualPyramid);

    }
}
