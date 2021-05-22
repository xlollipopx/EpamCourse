import org.junit.Test;
import org.xml.sax.SAXException;
import сom.epam.task.eight.data.Parser;
import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.data.parser.sax.PaperSaxBuilder;

import java.io.IOException;

public class PaperSaxBuilderTester extends AbstractBuilderTester{
    @Test
    public void testParseShouldReturnListDeviceWhenDataIsValid() throws ParserException, IOException, SAXException {
        super.testAbstractParseShouldBuildListWhenDataIsValid();
    }

    @Override
    public Parser getParser() {
        return new PaperSaxBuilder();
    }
}
