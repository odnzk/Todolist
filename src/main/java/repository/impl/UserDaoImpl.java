package repository.impl;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import mapper.UserMapper;
import model.User;
import repository.UserDao;
import util.AppDatabase;
import util.SimpleJdbcTemplate;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final String SQL_CREATE_USER = "insert into users(username, email, password) values (?, ?, ?)";
    private final String SQL_DELETE_USER = "delete from users cascade where id = ?";
    private final String SQL_SELECT_BY_USERNAME = "select * from users where username = ?";
    private final String SQL_UPDATE_USER = "update users\n" +
            "set published_date = '2020-07-01'\n" +
            "WHERE course_id = 2\n" +
            "RETURNING *;"; // todo


    private final UserMapper userMapper;
    private final SimpleJdbcTemplate simpleJdbcTemplate;

    public UserDaoImpl(UserMapper userMapper, SimpleJdbcTemplate simpleJdbcTemplate) {
        this.userMapper = userMapper;
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public void insert(User user) throws LoadingDbException {
        long id = simpleJdbcTemplate.update(SQL_CREATE_USER, user.getUsername(),
                user.getEmail(), user.getProjectIds(),
                user.getPassword());
        if (id != -1) {
            user.setId(id);
        }
    }

    @Override
    public void delete(User user) throws LoadingDbException {
        simpleJdbcTemplate.update(SQL_DELETE_USER, user.getId());
    }

    // todo optimize
    @Override
    public void update(User user) throws LoadingDbException {
        simpleJdbcTemplate.update(SQL_UPDATE_USER, user.getUsername(), user.getEmail(),
                user.getProjectIds(), user.getPassword());
    }

    @Override
    public Optional<User> findUserByUsername(String username) throws ConnectingDbException, LoadingDbException {
        List<User> users = simpleJdbcTemplate.query(SQL_SELECT_BY_USERNAME, userMapper, username);
        if(users.size() == 0){
            return Optional.empty();
        }
        return Optional.ofNullable(users.get(0));
    }

}
