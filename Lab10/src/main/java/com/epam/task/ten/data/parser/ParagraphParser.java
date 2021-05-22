package data.parser;

import data.parser.AbstractParser;
import data.parser.Parser;
import model.Component;
import model.Composite;

public class ParagraphParser extends AbstractParser {
    private static final String PARAGRAPH_REGEX = "[.!?]";

    public Component parse(String text) {
        return super.parse(text);
    }

    public String getRegex() {
        return PARAGRAPH_REGEX;
    }



}
