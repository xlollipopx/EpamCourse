package logic;

import data.TextReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final String REGEX = ".*\\[.+\\].*";
    private final static Logger LOGGER = LogManager.getLogger(TextReader.class);

    public boolean validate(String word) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(word);
        LOGGER.info("Validation result is " + matcher.matches());
        return matcher.matches();
    }
}