package com.epam.task.five.logic;

public class StringProcessorByCharSequence  implements StringProcessor{

    public String fixString(String string) {
        char [] text = string.toCharArray();
        for(int i = 0; i < text.length - 1; i++) {
            if(text[i] == 'p' && text[i + 1] == 'a') {
                text[i + 1] = 'o';
            }
        }
        return String.valueOf(text);
    }

}
