package сom.epam.task.eight.data;

import org.xml.sax.SAXException;
import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.model.Paper;

import java.io.IOException;
import java.util.List;

public interface Parser {
    List<Paper> parse(String fileName) throws ParserException, SAXException, IOException;
}
