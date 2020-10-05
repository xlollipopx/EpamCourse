package com.epam.task.five.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessorByRegularExpressions implements StringProcessor {

    public String fixString(String string) {
        Pattern pattern = Pattern.compile("pa");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            string = string.substring(0, matcher.start() + 1) + 'o' + string.substring(matcher.start() + 2);
        }
        return string;
    }

}
