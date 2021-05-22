package com.epam.task.seven.data;

import com.epam.task.seven.data.specification.Specification;

import java.util.List;

public interface Repository<T> {
    boolean add(T pyramid);
    boolean remove(T pyramid);
    void update(T pyramid);

    List<T> query(Specification<T> specification);
}
