package data.parser;

import data.parser.SentenceParser;
import model.Component;
import model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceParserTester {
    private static final String VALID_TEXT = "One Two [1_2+_]";
    private static final List<Component> EXPECTED_COMPONENTS = Arrays.asList(Leaf.createWord("One"),
            Leaf.createWord("Two"), Leaf.createExpression("[1_2+_]") );

    @Test
    public void testParseShouldCorrectParseWhenSentenceIsValid() {
        SentenceParser parser = new SentenceParser();
        Component actualComponent = parser.parse(VALID_TEXT);
        List<Component> actualComponents = actualComponent.getChildren();
        Assert.assertEquals(EXPECTED_COMPONENTS, actualComponents);
    }
}
