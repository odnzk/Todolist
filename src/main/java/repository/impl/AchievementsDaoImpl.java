package repository.impl;

import model.Achievement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.dao.AchievementDao;
import util.jdbc.mapper.AchievementsMapper;

import java.util.Optional;

public class AchievementsDaoImpl implements AchievementDao {
    private static final String SQL_CREATE_ACHIEVEMENT = "insert into achievements(title, category) values (?, ?)";
    private static final String SQL_DELETE_ACHIEVEMENT = "delete from achievements where achievement_id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from achievements where achievement_id = ? limit 1";
    private static final String SQL_UPDATE_TITLE = "update achievements set title = ? where achievement_id=?";

    private final AchievementsMapper achievementsMapper;
    private final JdbcTemplate jdbcTemplate;

    public AchievementsDaoImpl(AchievementsMapper achievementsMapper, JdbcTemplate jdbcTemplate) {
        this.achievementsMapper = achievementsMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Achievement item) {
        jdbcTemplate.update(SQL_CREATE_ACHIEVEMENT, item.getTitle());
    }

    @Override
    public void delete(Long itemId) {
        jdbcTemplate.update(SQL_DELETE_ACHIEVEMENT, itemId);
    }

    @Override
    public void update(Achievement item) {
        jdbcTemplate.update(SQL_UPDATE_TITLE, item.getTitle(), item.getId());
    }

    @Override
    public Optional<Achievement> findItem(Long itemId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SQL_SELECT_BY_ID,
                    achievementsMapper,
                    itemId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
