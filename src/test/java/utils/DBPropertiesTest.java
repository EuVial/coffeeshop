package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DBPropertiesTest {

    private static Properties PROPERTIES;

    @BeforeEach
    void setUp() {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readPropertyTest() {
        assertNotNull(PROPERTIES.getProperty("db.driver"));
        assertEquals(PROPERTIES.getProperty("db.driver"), "com.mysql.cj.jdbc.Driver");
        assertEquals(PROPERTIES.getProperty("db.url"), "jdbc:mysql:///coffeeshop?autoReconnect=true" +
                "&useSSL=false&useUnicode=true" +
                "&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false" +
                "&serverTimezone=UTC");
        assertEquals(PROPERTIES.getProperty("db.user"), "root");
        assertEquals(PROPERTIES.getProperty("db.password"), "pass");
    }
}