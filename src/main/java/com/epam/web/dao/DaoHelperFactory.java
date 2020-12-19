
package com.epam.web.dao;


import com.epam.web.controller.connection.ConnectionPool;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;

public class DaoHelperFactory {
    public DaoHelper create() throws DaoException, ConnectionPoolException {
        return new DaoHelper(ConnectionPool.getInstance());
    }
}


