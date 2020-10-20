package com.epam.task.seven.data.validation;

import com.epam.task.seven.logic.PyramidParametersCalculator;
import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;

import java.util.List;

public class PyramidValidator {
    public boolean isValid(List<Point> points) {
        if(points.size() != 4) {
            return false;
        }
        Pyramid pyramid = new Pyramid(points);
        PyramidParametersCalculator pyramidParametersCalculator = new PyramidParametersCalculator();
        return (pyramidParametersCalculator.calculateVolume(pyramid) != 0);
    }

}
