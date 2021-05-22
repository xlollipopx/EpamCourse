package com.epam.task.seven.data;

import com.epam.task.seven.data.validation.PyramidInputValidator;
import com.epam.task.seven.data.validation.PyramidValidator;
import com.epam.task.seven.model.Point;
import com.epam.task.seven.model.Pyramid;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class PyramidCreator {
    private PyramidValidator pyramidValidator = new PyramidValidator();
    private PyramidInputValidator pyramidInputValidation = new PyramidInputValidator();
    private final static Logger LOGGER = Logger.getLogger(Pyramid.class);

    public List<Pyramid> create(List<String> strings) {
        final String LINE_SEPARATOR = "\\s+";
        List<Pyramid> pyramidList = new LinkedList<>();

        for(String line: strings) {
            if(!pyramidInputValidation.isValid(line)) {
                LOGGER.error("Wrong input: " + line);
                continue;
            }
            String[] coordinates = line.split(LINE_SEPARATOR);
            double[] pointCoordinates = new double[coordinates.length];
            for(int i = 0; i < coordinates.length; i++) {
                pointCoordinates[i] = Double.parseDouble(coordinates[i]);
            }
            List<Point> pointList = new LinkedList<>();
            for(int i = 0; i < pointCoordinates.length; i += 3) {
                pointList.add(new Point(pointCoordinates[i],
                        pointCoordinates[i + 1], pointCoordinates[i + 2]));
            }
            if(pyramidValidator.isValid(pointList)){
                pyramidList.add(new Pyramid(pointList));
            }
        }
        return pyramidList;
    }
}
