package repository.impl;

import util.jdbc.mapper.UserAchievementsMapper;
import model.Achievement;
import model.User;
import model.ui.UiUserAchievement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

// insert userId, achievements id
// find all achievements by userId
public class UserAchievementsDaoImpl {
    private static final String SQL_CREATE_ACHIEVEMENT = "insert into _user_achievements(userId, achievementId) values (?, ?)";

    private static final String SQL_SELECT_ALL_USER_ACHIEVEMENTS = "select *\n" +
            "from (select userId, achievementId, achievements.title\n" +
            "from _user_achievements\n" +
            "    join achievements on achievements.id = _user_achievements.achievementId) as all\n" +
            "where userId = ?";

    private final UserAchievementsMapper userAchievementsMapper;
    private final JdbcTemplate jdbcTemplate;

    public UserAchievementsDaoImpl(UserAchievementsMapper userAchievementsMapper, JdbcTemplate jdbcTemplate) {
        this.userAchievementsMapper = userAchievementsMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    // todo move to interface
    public void insert(long userId, long achId) {
        jdbcTemplate.update(SQL_CREATE_ACHIEVEMENT, userId, achId);
    }

    // todo move to interface
    public Optional<UiUserAchievement> findAllUserAchievements(long userId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SQL_SELECT_ALL_USER_ACHIEVEMENTS,
                    userAchievementsMapper,
                    userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
