package logic;

import data.ChainBuilder;
import data.parser.TextParser;
import model.Component;
import model.Composite;
import org.junit.Assert;
import org.junit.Test;

public class CompositeProcessorTester {
    private static final String TEXT_ONE = "I like language java. Java is cool!\n" +
            "One plus one is [1_4_+_2_*_].";
    private static final String EXPECTED_STRING_ONE = "I like language java Java is cool "
            + "One plus one is [1_4_+_2_*_] ";
    private static final String EXPECTED_STRING_TWO = "I like language java Java is cool "
            + "One plus one is 10 ";
    public static final String TEXT_TWO  = "Onto Two! Three four five. Ten five.\n"+
            "I like language java. Java is cool!\n" +
            "One plus one is [1_4_+_2_*_].";

    public static final String EXPECTED_STRING_THREE = "One plus one is [1_4_+_2_*_] "+
            "I like language java Java is cool " +
            "Onto Two Three four five Ten five ";
    public static final String EXPECTED_STRING_FOUR = "Two Onto four five Three Ten five "+
            "I like java language is Java cool " +
            "is One one plus [1_4_+_2_*_] ";


    private static final ChainBuilder CHAIN_BUILDER = new ChainBuilder();
    private static final TextParser TEXT_PARSER = CHAIN_BUILDER.build();
    private static final CompositeProcessor calculator = new CompositeProcessor();

    @Test
    public void testRestoreShouldRestoreTextWhenTextIsValid() {
        Component composite = TEXT_PARSER.parse(TEXT_ONE);
        String actualRestoredText = calculator.restore(composite);
        Assert.assertEquals(actualRestoredText, EXPECTED_STRING_ONE);
    }

    @Test
    public void testCalculateShouldCalculateExpressionWhenItIsValid() {
        Component composite = TEXT_PARSER.parse(TEXT_ONE);
        Component actualComposite = calculator.calculate(composite);
        String actualCompositeRestoredText = calculator.restore(actualComposite);
        Assert.assertEquals(actualCompositeRestoredText, EXPECTED_STRING_TWO);
    }

    @Test
    public void testSortParagraphsShouldSortTextWhenItIsValid() {
        Component composite = TEXT_PARSER.parse(TEXT_TWO);
        Component actualComposite = calculator.sortParagraphs((Composite)composite);;
        String actualCompositeRestoredText = calculator.restore(actualComposite);
        Assert.assertEquals(actualCompositeRestoredText, EXPECTED_STRING_THREE);
    }

    @Test
    public void testSortSentencesByWordLengthShouldSortTextWhenItIsValid() {
        Component composite = TEXT_PARSER.parse(TEXT_TWO);
        Component actualComposite = calculator.sortSentencesByWordLength((Composite)composite);;
        String actualCompositeRestoredText = calculator.restore(actualComposite);
        Assert.assertEquals(actualCompositeRestoredText, EXPECTED_STRING_FOUR);
    }


}
