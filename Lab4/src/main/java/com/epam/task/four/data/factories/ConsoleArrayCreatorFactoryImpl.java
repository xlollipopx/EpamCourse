package com.epam.task.four.data.factories;

import com.epam.task.four.data.ConsoleArrayCreator;
import com.epam.task.four.model.Array;

public interface ConsoleArrayCreatorFactoryImpl {
    ConsoleArrayCreator create(int size);
}
