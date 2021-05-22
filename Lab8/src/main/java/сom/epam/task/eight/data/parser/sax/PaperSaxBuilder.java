package сom.epam.task.eight.data.parser.sax;


import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import сom.epam.task.eight.data.Parser;
import сom.epam.task.eight.model.Paper;
import java.io.IOException;
import java.util.List;

public class PaperSaxBuilder implements Parser {

    @Override
    public List<Paper> parse(String fileName) throws  SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        PaperHandler paperHandler = new PaperHandler();
        reader.setContentHandler(paperHandler);
        reader.parse(fileName);
        return paperHandler.getPaperList();
    }
}
