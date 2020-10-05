package com.epam.task.five;

import com.epam.task.five.data.StringAcquirer;
import com.epam.task.five.data.factories.StringAcquirerFactoryImpl;
import com.epam.task.five.data.factories.StringFactoryType;
import com.epam.task.five.exception.DataException;
import com.epam.task.five.logic.StringProcessorByRegularExpressions;
import com.epam.task.five.logic.StringProcessorByStringMethods;
import com.epam.task.five.view.StringViewer;


public class Main {
    public static void main(String[] args) throws DataException {


        StringAcquirerFactoryImpl stringAcquirerFactory = new StringAcquirerFactoryImpl();
        StringViewer stringViewer = new StringViewer();
        //FILE, by string methods
        StringAcquirer fileStringAcquirer = stringAcquirerFactory.create(StringFactoryType.FILE);
        String string = fileStringAcquirer.readString();
        StringProcessorByStringMethods stringProcessorByStringMethods = new StringProcessorByStringMethods();
        string = stringProcessorByStringMethods.fixString(string);
        stringViewer.view(string);

        //CONSOLE by regular expressions
        StringAcquirer consoleStringAcquirer = stringAcquirerFactory.create(StringFactoryType.CONSOLE);
        String string1 = consoleStringAcquirer.readString();
        StringProcessorByRegularExpressions stringProcessorByRegularExpressions = new StringProcessorByRegularExpressions();
        string1 = stringProcessorByRegularExpressions.fixString(string1);
        stringViewer.view(string1);

    }
}
