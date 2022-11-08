package util.jdbc.mapper;

import model.ui.UiUserAchievement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserAchievementsMapper implements RowMapper<UiUserAchievement> {

    @Override
    public UiUserAchievement mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getInt("id");
        String username = resultSet.getString("title");
        Boolean isUnlocked = resultSet.getBoolean("is_unlocked");
        return new UiUserAchievement(id, username, isUnlocked);
    }
}
