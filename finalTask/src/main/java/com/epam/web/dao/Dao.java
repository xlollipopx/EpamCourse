package com.epam.web.dao;

import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao <T> {

    Optional<T> getById(Long id);

    List<T> getAll() throws DaoException;

    boolean save(T item);

    void removeById(Long id);
}
