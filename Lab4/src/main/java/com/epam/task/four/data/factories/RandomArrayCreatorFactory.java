package com.epam.task.four.data.factories;

import com.epam.task.four.data.RandomArrayCreator;

public class RandomArrayCreatorFactory implements RandomArrayCreatorFactoryImpl{
    public RandomArrayCreator create(int size) {
        return new RandomArrayCreator(size);
    }
}
