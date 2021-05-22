package data.parser;

import data.parser.AbstractParser;
import model.Component;
import model.Composite;
import logic.ExpressionValidator;
import model.Leaf;

public class SentenceParser extends AbstractParser {
    private static final String SENTENCE_REGEX = " ";

    public Component parse(String text) {
        Composite component = new Composite();
        ExpressionValidator expressionValidator = new ExpressionValidator();
        for(String word : text.split(SENTENCE_REGEX)) {
            if(word.length() == 0){
                continue;
            }
            Leaf leaf;
            if(expressionValidator.validate(word)) {
                leaf = Leaf.createExpression(word);
            }
            else{
                leaf = Leaf.createWord(word);
            }
            component.add(leaf);
        }
        return component;
    }

    @Override
    protected String getRegex() {
        return SENTENCE_REGEX;
    }
}
