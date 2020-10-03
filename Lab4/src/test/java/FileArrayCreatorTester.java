
import com.epam.task.four.data.FileArrayCreator;
import com.epam.task.four.exception.ArgumentException;
import com.epam.task.four.model.Array;
import org.junit.Assert;
import org.junit.Test;

public class FileArrayCreatorTester {

    private final static String FILE_ONE = "src/test/java/resources/input1.txt";
    private final static String FILE_SECOND = "src/test/java/resources/input2.txt";

    private FileArrayCreator fileArrayCreator1 = new FileArrayCreator(FILE_ONE);
    private FileArrayCreator fileArrayCreator2 = new FileArrayCreator(FILE_SECOND);

    @Test(expected = ArgumentException.class)
    public void testFileArrayCreatorThrowException() {

        Array array = fileArrayCreator1.create();

    }

    @Test
    public void testFileArrayCreatorShouldReadFile() {
        //given
        Array array = fileArrayCreator2.create();
        //when
        Array expectedArray = new Array(42, 4, 6, 2);
        //then
        Assert.assertEquals(array, expectedArray);
    }

}
