package com.epam.web.dao;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> getById(Long id) throws DaoException;

    List<T> getAll(String tableName) throws DaoException;

    void save(T item) throws DaoException;

    void removeById(Long id);

}
