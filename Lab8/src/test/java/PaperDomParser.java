import org.junit.Test;
import org.xml.sax.SAXException;
import сom.epam.task.eight.data.Parser;
import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.data.parser.dom.PaperDomBuilder;

import java.io.IOException;

public class PaperDomParser extends AbstractBuilderTester{
    @Test
    public void testParseShouldReturnListDeviceWhenDataIsValid() throws ParserException, IOException, SAXException {
        super.testAbstractParseShouldBuildListWhenDataIsValid();
    }

    @Override
    public Parser getParser() {
        return new PaperDomBuilder();
    }
}
