
package com.epam.web.controller.connection;

import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private Queue<ProxyConnection> availableConnection;
    private Queue<ProxyConnection> connectionsInUse;
    private static final int POOL_SIZE = 10;
    private static final ReentrantLock LOCKER = new ReentrantLock();
    private static final ReentrantLock LOCKER_FOR_CLASS = new ReentrantLock();
    private static ConnectionPool instance = null;
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);


    public static ConnectionPool getInstance() throws ConnectionPoolException {
        if (!isCreated.get()) {
            LOCKER_FOR_CLASS.lock();
            try {
                if (!isCreated.get()) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                    LOGGER.info("Pool Created successfully.");
                }
            } catch (DaoException e) {
                throw new ConnectionPoolException(e.getMessage(), e);
            } finally {
                LOCKER_FOR_CLASS.unlock();
            }
        }
        return instance;
    }


    private ConnectionPool() throws DaoException {
        availableConnection = new ArrayDeque<>(POOL_SIZE);
        connectionsInUse = new ArrayDeque<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection = connectionFactory.createConnection();
            ProxyConnection proxyConnection = new ProxyConnection(connection);
            availableConnection.add(proxyConnection);
        }
    }


    public void releaseConnection(ProxyConnection proxyConnection) {
       //semafoere.ыуьфащку
        LOCKER.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                connectionsInUse.remove(proxyConnection);
                availableConnection.offer(proxyConnection);
            }
        } finally {
            LOCKER.unlock();
        }
    }

    public ProxyConnection getConnection() {
        LOCKER.lock();
        try {
            ProxyConnection proxyConnection = availableConnection.poll();
            connectionsInUse.offer(proxyConnection);
            LOGGER.info("Connection has been given");
            return proxyConnection;
        } finally {
            LOCKER.unlock();
        }
    }

    public void destroyPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            availableConnection.poll().close();
        }
        LOGGER.info("Connection pool has been destroyed");
    }

}

