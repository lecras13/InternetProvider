package com.epam.web.controller.connection;

import com.epam.web.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    public Connection createConnection() throws DaoException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
