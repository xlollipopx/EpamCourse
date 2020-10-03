package com.epam.task.four.data.factories;

import com.epam.task.four.data.FileArrayCreator;

public interface FileArrayCreatorFactoryImpl {
    FileArrayCreator create(String fileName);
}
