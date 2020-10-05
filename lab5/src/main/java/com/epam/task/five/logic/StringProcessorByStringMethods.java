package com.epam.task.five.logic;

public class StringProcessorByStringMethods implements StringProcessor{

    public String fixString(String string) {
        int index = 0;
        String subString = "pa";
        while(string.indexOf(subString, index) != -1) {
            int positionA = string.indexOf(subString, index);
            string = string.substring(0, positionA + 1) + 'o' + string.substring(positionA + 2);
            index = positionA;
        }
        return string;
    }

}
