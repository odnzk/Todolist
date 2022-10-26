package dao.impl;

import models.User;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl  {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

//    @Override
//    public void insertUser(User user) {
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
//            String sql = "insert into users(username, email,country, date, sex, password) values(?, ?, ?, ?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            java.sql.Date sqlDate = new java.sql.Date(user.getDate().getTime());
//            preparedStatement.setDate(4, sqlDate);
//            preparedStatement.setBoolean(5, user.getSex());
//            preparedStatement.setString(6, user.getPassword());
//
//            preparedStatement.execute();
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
