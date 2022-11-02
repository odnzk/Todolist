package mapper;

import model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {

    // todo what is i???
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getInt("id");
        String username = resultSet.getString("first_name");
        String email = resultSet.getString("last_name");
        String password = resultSet.getString("password");
        return new User(id, username, email, password);
    }
}
