package com.epam.task.five.data.factories;


import com.epam.task.five.data.ConsoleStringAcquirer;
import com.epam.task.five.data.FileStringAcquirer;
import com.epam.task.five.data.StringAcquirer;

public class StringAcquirerFactoryImpl implements StringAcquirerFactory {
    private static final String FILE_PATH = "input.txt";

    public StringAcquirer create(StringFactoryType stringFactoryType) {
       switch (stringFactoryType) {
           case CONSOLE:
               return new ConsoleStringAcquirer();
           case FILE:
               return new FileStringAcquirer(FILE_PATH);
           default:
               throw new IllegalArgumentException("Unrecognized type!");
       }
    }
}
