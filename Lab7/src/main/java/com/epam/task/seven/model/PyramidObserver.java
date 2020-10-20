package com.epam.task.seven.model;

import com.epam.task.seven.logic.PyramidParametersCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PyramidObserver {
    private Map<Integer, PyramidParameters> parametersMap = new HashMap<>();
    private PyramidParametersCalculator pyramidParametersCalculator = new PyramidParametersCalculator();
    private static final PyramidObserver INSTANCE = new PyramidObserver();

    private PyramidObserver() {
    }

    public static PyramidObserver getInstance() {
        return INSTANCE;
    }

    public Optional<Double> getVolume(int id) {
        if(!parametersMap.containsKey(id)){
            return Optional.empty();
        }
        PyramidParameters pyramidParameters = parametersMap.get(id);
        double volume = pyramidParameters.getVolume();
        return Optional.of(volume);
    }

    public Optional<Double> getSurfaceArea(int id) {
        if(!parametersMap.containsKey(id)){
            return Optional.empty();
        }
        PyramidParameters pyramidParameters = parametersMap.get(id);
        double surfaceArea = pyramidParameters.getSurfaceArea();
        return Optional.of(surfaceArea);
    }

    public void notify(Pyramid pyramid) {
        double volume = pyramidParametersCalculator.calculateVolume(pyramid);
        double surfaceArea = pyramidParametersCalculator.calculateSurfaceArea(pyramid);
        PyramidParameters pyramidParameters = new PyramidParameters(volume, surfaceArea);
        parametersMap.put(pyramid.getId(), pyramidParameters);
    }

}
