package com.epam.task.seven.data;

import com.epam.task.seven.Main;
import com.epam.task.seven.data.specification.Specification;
import com.epam.task.seven.model.Pyramid;
import org.apache.log4j.Logger;

import java.util.*;

public class PyramidRepository implements Repository<Pyramid>{
    private LinkedHashMap<Integer, Pyramid> pyramids = new LinkedHashMap<>();
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    @Override
    public boolean add(Pyramid pyramid) {
        int pyramidId = pyramid.getId();
        if(pyramids.containsKey(pyramidId)){
            LOGGER.error("Element with id " + pyramidId + " already exists!");
            return false;
        }
        pyramids.put(pyramidId, pyramid);
        return true;
    }

    public boolean add(List<Pyramid> pyramidList) {
        for(Pyramid pyramid: pyramidList) {
            int pyramidId = pyramid.getId();
            if(pyramids.containsKey(pyramidId)){
                LOGGER.error("Element with id " + pyramidId + " already exists!");
                return false;
            }
            pyramids.put(pyramid.getId(), pyramid);
        }
        return true;
    }

    @Override
    public boolean remove(Pyramid pyramid) {
        int pyramidId = pyramid.getId();
        if(!pyramids.containsKey(pyramidId)){
            LOGGER.error("Element with id " + pyramidId + " doesn't exist!");
            return false;
        }
        pyramids.remove(pyramidId);
        return true;
    }

    @Override
    public void update(Pyramid pyramid) {
        int pyramidId = pyramid.getId();
        pyramids.put(pyramidId, pyramid);
    }

    @Override
    public List<Pyramid> query(Specification<Pyramid> specification) {
        List<Pyramid> pyramidList = new LinkedList<>();
        for(Pyramid pyramid: pyramids.values()) {
            if(specification.specified(pyramid)) {
                pyramidList.add(pyramid);
            }
        }
        return pyramidList;
    }

    public List<Pyramid> sort(Comparator<Pyramid> comparator) {
        List<Pyramid> pyramidList = new ArrayList<>(pyramids.values());
        pyramidList.sort(comparator);
        return pyramidList;
    }

}
