package util;

import exceptions.ConnectingDbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// todo check all
public class AppDatabase {
    private static Connection connection;

    public static Connection getConnection() throws ConnectingDbException {
        if (connection == null) {
            Properties properties = new Properties();
            try (FileInputStream fi = new FileInputStream("/Users/olga/IdeaProjects/mavenhelpme/SemesterProject/src/main/resources/app.properties")) {
                properties.load(fi);

                Class.forName(properties.getProperty("db.driver"));
                connection = DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"), properties.getProperty("db.password"));
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            } catch (SQLException ex) {
                throw new ConnectingDbException("Can't connect to DB (" + ex.getErrorCode() + ": " + ex.getMessage() + ").");
            } catch (ClassNotFoundException ex) {
                throw new ConnectingDbException("Can't connect to DB: problems with driver (" + ex.getMessage() + ").");
            }
        }
        return connection;
    }
}
