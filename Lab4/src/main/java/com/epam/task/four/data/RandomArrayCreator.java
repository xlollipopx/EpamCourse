package com.epam.task.four.data;


import com.epam.task.four.model.Array;

public class RandomArrayCreator implements ArrayCreator{
    private int size;

    public RandomArrayCreator(int size) {
        this.size = size;
    }

    public Array create() {
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) Math.round((Math.random() * 101) - 50);
        }
        return new Array(numbers);
    }

}
