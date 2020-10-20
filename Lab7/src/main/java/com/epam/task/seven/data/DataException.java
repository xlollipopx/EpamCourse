package com.epam.task.seven.data;

public class DataException extends Exception{

    public DataException() {}

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}

