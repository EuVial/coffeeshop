package dao.datasource;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DBProperties;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private final static Logger LOGGER =
            LogManager.getLogger(DataSource.class);

    private static DataSource dataSource;
    private ComboPooledDataSource comboPooledDataSource;
    private static String jdbcUrl;
    private static String jdbcUser;
    private static String jdbcPassword;
    private static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(final String jdbcDriver, final String jdbcUrl, final String jdbcUser,
                            final String jdbcPassword) throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        DataSource.jdbcUrl = jdbcUrl;
        DataSource.jdbcUser = jdbcUser;
        DataSource.jdbcPassword = jdbcPassword;
        LOGGER.info("Connection pull successfully initialized");
    }

    private DataSource() {
        try {
            comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource
                    .setDriverClass(DBProperties.getDriver());
            comboPooledDataSource
                    .setJdbcUrl(DBProperties.getUrl());
            comboPooledDataSource.setUser(DBProperties.getUser());
            comboPooledDataSource.setPassword(DBProperties.getPassword());
        }
        catch (PropertyVetoException ex1) {
                LOGGER.error("Incorrect parameters sent to connection pool");
                ex1.printStackTrace();
            }
        }

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("Connection pool cannot get connection");
            e.printStackTrace();
        }
        return connection;
    }
}
