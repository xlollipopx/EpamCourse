package com.epam.task.seven.logic.comparator;

import com.epam.task.seven.model.Pyramid;

import java.util.Comparator;

public class PyramidVolumeComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid pyramidOne, Pyramid pyramidTwo) {
        double volumeOne = pyramidOne.getVolume();
        double volumeTwo = pyramidTwo.getVolume();
        return Double.compare(volumeOne,volumeTwo);
    }
}
