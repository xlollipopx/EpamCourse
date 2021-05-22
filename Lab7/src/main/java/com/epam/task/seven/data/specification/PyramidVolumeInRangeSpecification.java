package com.epam.task.seven.data.specification;

import com.epam.task.seven.model.Pyramid;

public class PyramidVolumeInRangeSpecification implements Specification<Pyramid> {
    private double minVolume;
    private double maxVolume;

    public PyramidVolumeInRangeSpecification(double minVolume, double maxVolume) {
       this.maxVolume = maxVolume;
       this.minVolume = minVolume;
    }

    @Override
        public boolean specified(Pyramid pyramid){
        double pyramidVolume = pyramid.getVolume();
        return (pyramidVolume <= maxVolume &&
                pyramidVolume >= minVolume);
    }
}
