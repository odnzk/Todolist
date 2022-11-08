package repository.impl;

import util.jdbc.mapper.UserMapper;
import model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.UserDao;

import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final String SQL_CREATE_USER = "insert into users(username, email, password) values (?, ?, ?)";
    private static final String SQL_DELETE_USER = "delete from users where username = ?";
    private static final String SQL_SELECT_BY_USERNAME = "select * from users where username = ? limit 1";

    private static final String SQL_UPDATE_USERNAME = "update users set username = ? where id=?;";
    private static final String SQL_UPDATE_PASSWORD = "update users set password = ? where id=?;";
    private static final String SQL_UPDATE_EMAIL = "update users set email = ? where id=?;";


    private final UserMapper userMapper;
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(UserMapper userMapper, JdbcTemplate jdbcTemplate) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(User user) {
        jdbcTemplate
                .update(SQL_CREATE_USER,
                        user.getUsername(),
                        user.getEmail(),
                        user.getPassword());
    }

    @Override
    public void delete(User user) {
        jdbcTemplate.update(SQL_DELETE_USER, user.getUsername());
    }

    @Override
    public void update(User user) {
        User notUpdated = findUserByUsername(user.getUsername()).get();
        if (!user.getUsername().equals(notUpdated.getUsername())) {
            jdbcTemplate.update(SQL_UPDATE_USERNAME, user.getUsername(), user.getId());
        }
        if (!user.getPassword().equals(notUpdated.getPassword())) {
            jdbcTemplate.update(SQL_UPDATE_PASSWORD, user.getPassword(), user.getId());
        }
        if (!user.getEmail().equals(notUpdated.getEmail())) {
            jdbcTemplate.update(SQL_UPDATE_EMAIL, user.getEmail(), user.getId());
        }
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        try{
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SQL_SELECT_BY_USERNAME,
                    userMapper,
                    username));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
//        User res = jdbcTemplate.queryForObject(
//                SQL_SELECT_BY_USERNAME,
//                userMapper,
//                username);
//        return Optional.ofNullable(res);
    }

}
