package util.jdbc.mapper;

import model.Achievement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AchievementsMapper implements RowMapper<Achievement> {

    @Override
    public Achievement mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("achievement_id");
        String username = resultSet.getString("title");
        String category = resultSet.getString("category");
        return new Achievement(id, username, category);
    }
}
