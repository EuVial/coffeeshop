package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ScriptReader {
    static public void execute(String filePath, Connection connection) {
        try (Statement statement = connection.createStatement()) {
            for (String str : Files.readAllLines(Paths.get(filePath))) {
                statement.execute(str);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
