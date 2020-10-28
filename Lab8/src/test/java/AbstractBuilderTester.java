import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import сom.epam.task.eight.data.Parser;
import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.model.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractBuilderTester {

    private final static String XML_NAME = "src/test/java/resources/papers.xml";

    @Test
    public void testAbstractParseShouldBuildListWhenDataIsValid() throws IOException, ParserException, SAXException {
        //given
        Magazine magazineOne = new Magazine("ID-1", "Cosmopolitan",
                true, "blue", 40, Type.MAGAZINE, true, "Cosmo");
        ScienceMagazine scienceMagazine = new ScienceMagazine("ID-2", "Cosmos",
                false, "green", 50, Type.MAGAZINE,
                true, "Cosmo", 280);
        NewsPaper newsPaper = new NewsPaper("ID-3", "Daily Mail",
                true, "blue", 30, Type.NEWSPAPER, 1003);
        Magazine magazineTwo = new Magazine("ID-5", "Cosmopolitan",
                true, "red", 100, Type.MAGAZINE, true, "Cosmo");
        List<Paper> expectedPaper = Arrays.asList(magazineOne, scienceMagazine, newsPaper, magazineTwo);
        //when
        Parser parser = getParser();
        List<Paper> actualPaper = parser.parse(XML_NAME);
        //then
        Assert.assertEquals(expectedPaper, actualPaper);
    }

    public abstract Parser getParser();
}
