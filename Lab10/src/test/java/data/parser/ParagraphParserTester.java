package data.parser;

import data.parser.ParagraphParser;
import data.parser.Parser;
import data.parser.SentenceParser;
import data.parser.TextParser;
import model.Component;
import model.Composite;
import model.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ParagraphParserTester {
    private static final String VALID_TEXT = "One!One!";
    private static final Component LEAF = Leaf.createWord("One");
    private static final Component SENTENCE = new Composite(new ArrayList<>(Collections.singletonList(LEAF)));
    private static final Component EXPECTED_COMPONENT= new Composite(new ArrayList<>(Arrays.asList(SENTENCE,SENTENCE)));


    @Test
    public void testParseShouldReturnCorrectComponents() {
        ParagraphParser paragraphParser = new ParagraphParser();
        Parser sentenceParser = Mockito.mock(SentenceParser.class);
        paragraphParser.setSuccessor(sentenceParser);
        when(paragraphParser.parse(VALID_TEXT)).
                thenAnswer(invocation -> {
                    Leaf leaf = Leaf.createWord(((String) invocation.getArgument(0)));
                    Component component = new Composite(new ArrayList<>(Collections.singletonList(leaf)));
                            return component;
                }
                );
        Component actualComponent = paragraphParser.parse(VALID_TEXT);
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}
