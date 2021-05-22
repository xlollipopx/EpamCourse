package сom.epam.task.eight.data.parser.sax;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import сom.epam.task.eight.data.factory.PaperFactory;
import сom.epam.task.eight.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaperHandler extends DefaultHandler {
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
    private static final String IMPACT_FACTOR = "impact-factor";

    private String currentClassName = null;
    private PaperFactory paperFactory = new PaperFactory();
    private Paper currentPaper = null;
    private String currentField = null;
    private List<Paper> paperList;
    private List<String> fieldValues;

    public PaperHandler() {
        paperList = new ArrayList<>();
        fieldValues = Arrays.asList(ID, TITLE, MONTHLY, COLOR, PAGES_NUMBER,
                TYPE, SUBSCRIPTION_INDEX, GLOSSY, PUBLISHING_OFFICE, IMPACT_FACTOR);
    }
    
    public List<Paper> getPaperList() {
        return paperList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (MAGAZINE.equals(localName) || SCIENCE_MAGAZINE.equals(localName)
                || NEWSPAPER.equals(localName)) {
            currentPaper = paperFactory.create(localName);
            currentClassName = localName;
            String id = attrs.getValue(ID);
            currentPaper.setId(id);
        }
       else if (fieldValues.contains(localName)) {
            currentField = localName;
        }
    }

    @Override
    public void characters(char[ ] ch, int start, int length) {
        String value = new String(ch, start, length);
        value = value.trim();

        if(currentField != null) {
            switch (currentField) {
                case TITLE:
                    currentPaper.setTitle(value);
                    break;
                case MONTHLY:
                    boolean isMonthly = "true".equals(value);
                   currentPaper.setMonthly(isMonthly);
                    break;
                case COLOR:
                    currentPaper.setColor(value);
                    break;
                case PAGES_NUMBER:
                    int pagesNumber = Integer.parseInt(value);
                    currentPaper.setPagesNumber(pagesNumber);
                    break;
                case TYPE:
                    currentPaper.setType(Type.valueOf(value));
                    break;
                case SUBSCRIPTION_INDEX:
                    if(NEWSPAPER.equals(currentClassName)){
                        int index = Integer.parseInt(value);
                        ((NewsPaper) currentPaper).setSubscriptionIndex(index);
                    }
                    break;
                case GLOSSY:
                    setGlossy(value);
                    break;
                case PUBLISHING_OFFICE:
                   setPublishingOffice(value);
                    break;
                case IMPACT_FACTOR:
                    int impact = Integer.parseInt(value);
                    ((ScienceMagazine) currentPaper).setImpactFactor(impact);
                    break;
                default:
                    throw new IllegalArgumentException("No such field! " + value);
            }
            currentField = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (MAGAZINE.equals(localName) || SCIENCE_MAGAZINE.equals(localName) || NEWSPAPER.equals(localName)) {
            paperList.add(currentPaper);
        }
    }

    private void setGlossy(String value) {
        boolean isGlossy = "true".equals(value);
        if(MAGAZINE.equals(currentClassName)) {
            ((Magazine) currentPaper).setGlossy(isGlossy);
        }
        else if(SCIENCE_MAGAZINE.equals(currentClassName)){
            ((ScienceMagazine) currentPaper).setGlossy(isGlossy);
        }
    }

    private void setPublishingOffice(String value) {
        if(MAGAZINE.equals(currentClassName)) {
            ((Magazine) currentPaper).setPublishingOffice(value);
        }
        else if(SCIENCE_MAGAZINE.equals(currentClassName)){
            ((ScienceMagazine) currentPaper).setPublishingOffice(value);
        }
    }


}
