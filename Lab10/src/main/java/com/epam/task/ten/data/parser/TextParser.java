package data.parser;

import data.parser.AbstractParser;
import data.parser.Parser;
import model.Component;
import model.Composite;

public class TextParser extends AbstractParser {
    private static final String TEXT_REGEX = "\n";

    public Component parse(String text) {
        return super.parse(text);
    }

    public String getRegex() {
        return TEXT_REGEX;
    }


}
