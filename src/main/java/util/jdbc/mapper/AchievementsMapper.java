package util.jdbc.mapper;

import model.Achievement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AchievementsMapper implements RowMapper<Achievement> {

    @Override
    public Achievement mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getInt("id");
        String username = resultSet.getString("title");
        return new Achievement(id, username);
    }
}
