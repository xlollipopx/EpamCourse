package com.epam.web.connection;

import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionsInUse;
    private ReentrantLock connectionsLock = new ReentrantLock();
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private static final int POOL_SIZE = 10;
    private static volatile ConnectionPool instance;

    private ConnectionPool() throws DaoException {
        availableConnections = new ArrayDeque<>();
        connectionsInUse = new ArrayDeque<>();
        for(int i = 0; i < POOL_SIZE; i++) {
            Connection connection = connectionFactory.create();
            ProxyConnection proxyConnection = new ProxyConnection(this, connection);
            availableConnections.add(proxyConnection);
        }
    }

    //TODO: add lock here
    public static ConnectionPool getInstance() {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionPool.class) {
                localInstance = instance;
                if (localInstance == null) {
                    try {
                        instance = localInstance = new ConnectionPool();
                    } catch ( DaoException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return localInstance;
    }


    public void returnConnection (ProxyConnection proxyConnection) {
        connectionsLock.lock();
        try {
            if(connectionsInUse.contains(proxyConnection)){
                availableConnections.offer(proxyConnection);
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() {
        connectionsLock.lock();
        try{
            ProxyConnection proxyConnection = availableConnections.poll();
            connectionsInUse.offer(proxyConnection);
            return proxyConnection;
        } finally {
            connectionsLock.unlock();
        }
    }

    //TODO close connections
    public void closeConnections() {
        while(availableConnections.size() > 0) {
            ProxyConnection activeConnection = connectionsInUse.poll();
            availableConnections.offer(activeConnection);
            ProxyConnection availableConnection = availableConnections.poll();
            try {
                availableConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
