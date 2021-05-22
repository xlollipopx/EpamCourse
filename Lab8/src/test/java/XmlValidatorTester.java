import org.junit.Assert;
import org.junit.Test;
import сom.epam.task.eight.data.XmlValidator;

public class XmlValidatorTester {
    private final static String XML_NAME = "src/test/java/resources/papers.xml";
    private final static String XML_INVALID_NAME = "src/test/java/resources/invalidPapers.xml";
    private final static String XSD_NAME = "src/test/java/resources/papers.xsd";


    @Test
    public void testValidShodReturnTrueWhenDataIsValid(){
        //given
        XmlValidator validator = new XmlValidator(XSD_NAME);
        boolean actual  = validator.valid(XML_NAME);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidShodReturnFalseWhenDataNotCorrect(){
        //given
        XmlValidator validator = new XmlValidator(XSD_NAME);
        boolean actual  = validator.valid(XML_INVALID_NAME);
        //then
        Assert.assertFalse(actual);
    }

}

