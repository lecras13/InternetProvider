package com.epam.web.dao;

import com.epam.web.controller.connection.ConnectionPool;
import com.epam.web.controller.connection.ProxyConnection;
import com.epam.web.exception.DaoException;


import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoHelper implements AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(DaoHelper.class);

    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws DaoException {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        LOGGER.info("USER_HELPER in load");
        return new UserDaoImpl(connection);
    }

    public TariffPlansDao createTariffDao() {
        LOGGER.info("Tariff_HELPER in load");
        return new TariffPlansDaoImpl(connection);
    }

    public UserDao createPromotionDao() {
        LOGGER.info("Promotion_HELPER in load");
        return new UserDaoImpl(connection);
    }

    @Override
    public void close()  {
        connection.close();
    }

    public void startTransAction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}



