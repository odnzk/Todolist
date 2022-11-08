package repository.impl;

import util.jdbc.mapper.AchievementsMapper;
import model.Achievement;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.GeneralDao;

import java.util.Optional;

public class AchievementsDaoImpl implements GeneralDao<Achievement> {
    private static final String SQL_CREATE_ACHIEVEMENT = "insert into achievements(title) values (?)";
    private static final String SQL_DELETE_ACHIEVEMENT = "delete from achievements where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from achievements where id = ? limit 1";
    private static final String SQL_UPDATE_TITLE = "update achievements set title = ? where id=?";


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
    public void delete(Achievement item) {
        jdbcTemplate.update(SQL_DELETE_ACHIEVEMENT, item.getId());
    }

    @Override
    public void update(Achievement item) {
        jdbcTemplate.update(SQL_UPDATE_TITLE, item.getTitle(), item.getId());
    }

    // todo move to interface
    public Optional<Achievement> select(long achievementId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    SQL_SELECT_BY_ID,
                    achievementsMapper,
                    achievementId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
