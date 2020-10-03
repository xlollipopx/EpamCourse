package com.epam.task.four.data;

import com.epam.task.four.exception.ArgumentIOException;
import com.epam.task.four.model.Array;

import java.io.*;
import java.util.Scanner;

public class ConsoleArrayCreator implements ArrayCreator {

    private int size;

    public ConsoleArrayCreator(int size) {
        this.size = size;
    }

    public Array create() {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        return new Array(numbers);
    }
}