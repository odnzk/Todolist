package repository.impl;

import model.Achievement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import util.jdbc.mapper.AchievementsMapper;

import java.util.List;
import java.util.Optional;

// insert userId, achievements id
// find all achievements by userId
// todo move to interface
public class UserAchievementsDaoImpl {
    private static final String SQL_CREATE_USER_ACHIEVEMENT = "insert into _user_achievements(userId, achievement_id) values (?, ?)";
    private static final String SQL_SELECT_ALL = "select * from achievements";
    private static final String SQL_SELECT_BY_ACHIV_ID = "select * from _user_achievements where achievement_id = ?";
    private static final String SQL_SELECT_ALL_USER_ACHIEVEMENTS = "select *\n" +
            "from (select userId, achievements.achievement_id, achievements.title, achievements.category\n" +
            "      from _user_achievements\n" +
            "               join achievements on achievements.achievement_id = _user_achievements.achievement_id) as foo\n" +
            "where userId = ?";

    private final AchievementsMapper achievementsMapper;
    private final JdbcTemplate jdbcTemplate;

    public UserAchievementsDaoImpl(AchievementsMapper achievementsMapper, JdbcTemplate jdbcTemplate) {
        this.achievementsMapper = achievementsMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(long userId, long achId) {
        jdbcTemplate.update(SQL_CREATE_USER_ACHIEVEMENT, userId, achId);
    }

    public Optional<List<Achievement>> findAllUserAchievements(long userId) {
        try {
            return Optional.of(jdbcTemplate.query(
                    SQL_SELECT_ALL_USER_ACHIEVEMENTS,
                    achievementsMapper,
                    userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public Optional<List<Achievement>> findAllAchievements() {
        try {
            return Optional.of(jdbcTemplate.query(
                    SQL_SELECT_ALL,
                    achievementsMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public boolean isAchievementUnlocked(Long achivId){
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ACHIV_ID, Integer.class) != null;
    }
}
