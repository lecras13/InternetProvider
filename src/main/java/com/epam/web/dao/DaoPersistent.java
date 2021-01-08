package com.epam.web.dao;

import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface DaoPersistent<T> {
    Optional<T> getById(Long id) throws DaoException;

    List<T> getAll() throws DaoException;

    void save(T item) throws DaoException;

    void removeById(Long id) throws DaoException;
}
