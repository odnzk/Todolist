package repository.impl;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import mapper.UserMapper;
import model.User;
import repository.UserDao;
import util.SimpleJdbcTemplate;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final String SQL_CREATE_USER = "create ..."; // todo
    private final String SQL_DELETE_USER = "delete user from users where id =?"; // todo
    private final String SQL_SELECT_BY_USERNAME = "select * from users where username = ?";

    private final UserMapper userMapper = new UserMapper();
    private final SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate();

    @Override
    public void insert(User user) {
//        List<> accounts = simpleJdbcTemplate.query(SQL_SELECT_BY_EMAIL, rowMapper, email);
//        if(accounts.size() != 0){
//            return Optional.of(accounts.get(0));
//        }
//        return Optional.empty();

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findUserByUsername(String username) throws ConnectingDbException, LoadingDbException {
        List<User> users = simpleJdbcTemplate.query(SQL_SELECT_BY_USERNAME, userMapper, username);
        return Optional.ofNullable(users.get(0));
    }

}
