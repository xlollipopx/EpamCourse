package com.epam.task.seven.data.validation;

public class PyramidInputValidator implements InputValidator {
    private static final String PYRAMID_REGEX =
            "(-?\\d+(\\.\\d+)?\\s+){11}(-?\\d+(\\.\\d+)?)";
    @Override
    public boolean isValid(String line) {
        return line.matches(PYRAMID_REGEX);
    }
}
