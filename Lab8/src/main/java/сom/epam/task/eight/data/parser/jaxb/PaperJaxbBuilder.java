package сom.epam.task.eight.data.parser.jaxb;

import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.model.Paper;
import сom.epam.task.eight.model.Papers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import сom.epam.task.eight.data.Parser;

public class PaperJaxbBuilder implements Parser {

    @Override
    public List<Paper> parse(String fileName) throws ParserException {
        Papers papers = new Papers();
        try {
            JAXBContext jc = JAXBContext.newInstance(Papers.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(fileName);
           papers = (Papers) u.unmarshal(reader);
        } catch (JAXBException  | FileNotFoundException e) {
            throw new ParserException(e.getMessage(), e);
        }
        return papers.getPapers();
    }
}
