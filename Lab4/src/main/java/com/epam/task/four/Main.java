package com.epam.task.four;

import com.epam.task.four.data.ConsoleArrayCreator;
import com.epam.task.four.data.FileArrayCreator;
import com.epam.task.four.data.RandomArrayCreator;
import com.epam.task.four.data.factories.FileArrayCreatorFactory;
import com.epam.task.four.logic.ArrayProcessor;
import com.epam.task.four.model.Array;
import com.epam.task.four.view.ArrayConsoleViewer;

public class Main {
    public static void main(String[] args) {
        String FILE_ONE = "input.txt";

        FileArrayCreatorFactory fileArrayCreatorFactory = new FileArrayCreatorFactory();
        FileArrayCreator fileArrayCreator = fileArrayCreatorFactory.create(FILE_ONE);
        Array array = fileArrayCreator.create();

        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.sortArray(array);
        ArrayConsoleViewer arrayConsoleViewer = new ArrayConsoleViewer();
        arrayConsoleViewer.view(array);

        ConsoleArrayCreator consoleArrayCreator = new ConsoleArrayCreator(5);
        Array array1 = consoleArrayCreator.create();

        RandomArrayCreator randomArrayCreator = new RandomArrayCreator(9);
        Array array2 = randomArrayCreator.create();
        arrayConsoleViewer.view(array2);

    }
}
