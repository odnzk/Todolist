package util.jdbc.mapper;

import model.Achievement;
import model.ui.UiUserAchievement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


//public class UserAchievementsMapper implements RowMapper<UiUserAchievement> {
//
//    @Override
//    public UiUserAchievement mapRow(ResultSet resultSet, int i) throws SQLException {
//        // userId, achievementId, achievements.title, achievements.category
//        Long id = resultSet.getLong("achievementId");
//        String title = resultSet.getString("title");
//        String category = resultSet.getString("category");
//        return new UiUserAchievement(new Achievement(id, title, category), true);
//    }
//}
