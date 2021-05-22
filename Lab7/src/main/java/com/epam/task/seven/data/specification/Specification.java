package com.epam.task.seven.data.specification;

public interface Specification<T> {
    boolean specified(T object);
}
