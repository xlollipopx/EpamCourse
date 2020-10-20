package com.epam.task.seven.data.specification;

import com.epam.task.seven.model.Pyramid;

public class PyramidIdSpecification implements Specification<Pyramid> {
    private int id;

    public PyramidIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        return id == pyramid.getId();
    }
}
