package com.epam.task.four.data;


import com.epam.task.four.exception.ArgumentException;
import com.epam.task.four.model.Array;

public class StringToArrayParser {

    public Array parse(String line) {
        String[] lines = line.split("\\s");
        int[] numbers = new int[lines.length];
        for(int i = 0; i < lines.length; i++) {
            if (!lines[i].matches("[-+]?\\d+")) {
                    throw new ArgumentException(lines[i] + " not a number!");
            }
            numbers[i] = Integer.parseInt(lines[i]);
        }
        return new Array(numbers);
    }

}
