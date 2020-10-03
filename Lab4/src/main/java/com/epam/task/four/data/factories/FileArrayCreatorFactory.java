package com.epam.task.four.data.factories;

import com.epam.task.four.data.ConsoleArrayCreator;
import com.epam.task.four.data.FileArrayCreator;

public class FileArrayCreatorFactory implements FileArrayCreatorFactoryImpl{
    public FileArrayCreator create(String fileName) {
        return new FileArrayCreator(fileName);
    }
}
