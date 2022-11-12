package util.jdbc;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppDataSource {
    private DriverManagerDataSource dataSource;

    public DriverManagerDataSource getInstance() {
        if (dataSource == null) {
            create();
        }
        return dataSource;
    }

    public void create() {
        DriverManagerDataSource dc = new DriverManagerDataSource();
        Properties properties = new Properties();
        try (FileInputStream fi = new FileInputStream("/Users/olga/IdeaProjects/mavenhelpme/SemesterProject/src/main/resources/app.properties")) {
            properties.load(fi);
            dc.setDriverClassName(properties.getProperty("db.driver"));
            dc.setUrl(properties.getProperty("db.url"));
            dc.setUsername(properties.getProperty("db.user"));
            dc.setPassword(properties.getProperty("db.password"));
            dataSource = dc;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
