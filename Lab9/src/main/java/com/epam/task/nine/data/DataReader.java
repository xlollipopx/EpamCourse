package com.epam.task.nine.data;

public interface DataReader {
    String read(String fileName) throws DataException;
}
