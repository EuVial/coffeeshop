package dao.mysql.coffee.dbUnit;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import utils.ScriptReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUnitConfig extends DBTestCase {
    protected IDatabaseTester tester;
    private Properties prop;
    protected IDataSet beforeData;
    protected Connection connection;

    @Before
    public void setUp() throws Exception {
        tester = new JdbcDatabaseTester(prop.getProperty("db.driver"),
                prop.getProperty("db.url"),
                prop.getProperty("db.username"),
                prop.getProperty("db.password"),
                prop.getProperty("db.schema"));
        connection = DriverManager.getConnection(prop.getProperty("db.url"),
                prop.getProperty("db.username"),
                prop.getProperty("db.password"));
        ScriptReader.execute("src/test/h2sql/dump/COFFEE_TYPE.sql", connection);
    }

    public DBUnitConfig(String name) {
        super(name);
        prop = new Properties();
        try {
            prop.load(Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream("db.config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, prop.getProperty("db.driver"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, prop.getProperty("db.url"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, prop.getProperty("db.username"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, prop.getProperty("db.password"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, prop.getProperty("db.schema"));
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return beforeData;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE_ALL;
    }

}