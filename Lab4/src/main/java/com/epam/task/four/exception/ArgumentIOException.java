package com.epam.task.four.exception;

import java.io.IOException;

public class ArgumentIOException extends IOException {
    public ArgumentIOException() {
    }

    public ArgumentIOException(String message) {
        super(message);
    }

    public ArgumentIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentIOException(Throwable cause) {
        super(cause);
    }
}
