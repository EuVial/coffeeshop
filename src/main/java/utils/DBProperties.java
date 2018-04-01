package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {
    private static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDriver() {
        return PROPERTIES.getProperty("db.driver");
    }

    public static String getUrl() {
        return PROPERTIES.getProperty("db.url");
    }

    public static String getUser() {
        return PROPERTIES.getProperty("db.user");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("db.password");
    }
}
