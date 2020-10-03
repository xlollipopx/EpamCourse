package com.epam.task.four.data.factories;

import com.epam.task.four.data.ConsoleArrayCreator;
import com.epam.task.four.data.RandomArrayCreator;

public interface RandomArrayCreatorFactoryImpl {
    RandomArrayCreator create(int size);
}
