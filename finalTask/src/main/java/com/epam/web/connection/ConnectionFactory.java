package com.epam.web.connection;

import com.epam.web.exception.DaoException;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public  Connection create() throws DaoException {
        //TODO property file
        String url = "jdbc:mysql://localhost/mydb?useUnicode=true&serverTimezone=UTC";
        Properties properties = new Properties();
        properties.put("user","root");
        properties.put("password","anton");
        properties.put("autoReconnect","true");
        properties.put("characterEncoding","UTF-8");
        properties.put("useUnicode", true);

        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }

    }

}
