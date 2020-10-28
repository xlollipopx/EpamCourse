package сom.epam.task.eight;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.data.parser.dom.PaperDomBuilder;
import сom.epam.task.eight.data.parser.sax.PaperHandler;
import сom.epam.task.eight.data.parser.sax.PaperSaxBuilder;
import сom.epam.task.eight.data.parser.jaxb.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            PaperJaxbBuilder jaxbParser = new PaperJaxbBuilder();
            System.out.println(jaxbParser.parse("papers.xml"));
            PaperSaxBuilder paperSaxBuilder = new PaperSaxBuilder();
            System.out.println(paperSaxBuilder.parse("papers.xml"));
            PaperDomBuilder paperDomBuilder = new PaperDomBuilder();
            System.out.println(paperDomBuilder.parse("papers.xml"));
        } catch (ParserException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
