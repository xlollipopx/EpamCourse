package сom.epam.task.eight.data.parser.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import сom.epam.task.eight.data.Parser;
import сom.epam.task.eight.data.ParserException;
import сom.epam.task.eight.data.factory.PaperFactory;
import сom.epam.task.eight.model.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PaperDomBuilder implements Parser {
    private static final String  MAGAZINE = "magazine";
    private static final String  NEWSPAPER = "newspaper";
    private static final String  SCIENCE_MAGAZINE= "science-magazine";
    private static final String  ID = "id";
    private static final String  TITLE = "title";
    private static final String  MONTHLY = "monthly";
    private static final String  COLOR = "color";
    private static final String  PAGES_NUMBER = "pages-number";
    private static final String  TYPE = "type";
    private static final String  SUBSCRIPTION_INDEX = "subscription-index";
    private static final String  GLOSSY = "glossy";
    private static final String  PUBLISHING_OFFICE= "publishing-office";
    private static final String  IMPACT_FACTOR = "impact-factor";
    private static final int FIRST = 0;

    private PaperFactory paperFactory = new PaperFactory();
    private List<String> fieldValues;

    public PaperDomBuilder() {
        fieldValues = Arrays.asList(ID, TITLE, MONTHLY, COLOR, PAGES_NUMBER,
                TYPE, SUBSCRIPTION_INDEX, GLOSSY, PUBLISHING_OFFICE, IMPACT_FACTOR);
    }

    @Override
    public List<Paper> parse(String fileName) throws ParserException {
        List<Paper> papers = new LinkedList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList papersNodes = root.getChildNodes();

            for(int i = 0; i < papersNodes.getLength(); i++) {
                if (papersNodes.item(i) instanceof Element) {
                    Element paperElement = (Element) papersNodes.item(i);
                    Paper paper = buildPaper(paperElement);
                    papers.add(paper);
                }
            }


        } catch (SAXException | IOException e) {
            throw new ParserException(e.getMessage(), e);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return papers;
    }

    private Paper buildPaper(Element paperElement) {
        final String nodeName = paperElement.getNodeName();
        Paper paper = paperFactory.create(nodeName);
        String id = paperElement.getAttribute(ID);
        paper.setId(id);
        Type paperType = Type.valueOf(getElementContent(paperElement, TYPE));
        paper.setType(paperType);
        int pagesNumber = Integer.parseInt(getElementContent(paperElement, PAGES_NUMBER));
        paper.setPagesNumber(pagesNumber);
        boolean isMonthly = "true".equals(getElementContent(paperElement, MONTHLY));
        paper.setMonthly(isMonthly);
        paper.setColor(getElementContent(paperElement, COLOR));
        paper.setTitle(getElementContent(paperElement, TITLE));
        switch(nodeName) {
            case MAGAZINE:
                ((Magazine)paper).setPublishingOffice(
                        getElementContent(paperElement,PUBLISHING_OFFICE));
                boolean isGlossy = "true".equals(getElementContent(paperElement,GLOSSY));
                ((Magazine)paper).setGlossy(isGlossy);
                break;
            case NEWSPAPER:
                int index = Integer.parseInt(getElementContent(paperElement, SUBSCRIPTION_INDEX));
                ((NewsPaper)paper).setSubscriptionIndex(index);
                break;
            case SCIENCE_MAGAZINE:
                ((ScienceMagazine)paper).setPublishingOffice(
                        getElementContent(paperElement,PUBLISHING_OFFICE));
                boolean isGlossyOne = "true".equals(getElementContent(paperElement,GLOSSY));
                ((ScienceMagazine)paper).setGlossy(isGlossyOne);
                int impact = Integer.parseInt(getElementContent(paperElement, IMPACT_FACTOR));
                ((ScienceMagazine)paper).setImpactFactor(impact);
        }

        return paper;
    }

    private String getElementContent(Element element, String elementName) {
        NodeList nodes = element.getElementsByTagName(elementName);
        Node node = nodes.item(FIRST);
        String content = node.getTextContent();
        return content.trim();
    }

}
