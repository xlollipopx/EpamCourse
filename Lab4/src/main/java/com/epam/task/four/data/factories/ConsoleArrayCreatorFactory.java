package com.epam.task.four.data.factories;

import com.epam.task.four.data.ConsoleArrayCreator;

public class ConsoleArrayCreatorFactory implements ConsoleArrayCreatorFactoryImpl {
    public ConsoleArrayCreator create(int size) {
        return new ConsoleArrayCreator(size);
    }

}
