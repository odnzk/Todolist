package repository.impl;

import model.Project;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.dao.ProjectDao;
import util.jdbc.mapper.ProjectMapper;

import java.util.List;
import java.util.Optional;

public class ProjectDaoImpl implements ProjectDao {
    private static final String SQL_CREATE_PROJECT = "insert into projects(userId, title, is_completed, start_date, finish_date) values (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PROJECT = "delete from projects where id = ?";
    private static final String SQL_DELETE_ALL = "delete from projects where userId = ?";
    private static final String SQL_SELECT_BY_ID = "select * from projects where id = ? limit 1";
    private static final String SQL_SELECT_BY_USER_ID = "select * from projects where userid = ?";

    private static final String SQL_UPDATE_PROJECT_TITLE = "update projects set title = ? where id=?;";
    private static final String SQL_UPDATE_PROJECT_IS_COMPLETED = "update projects set is_completed = ? where id=?;";


    private final ProjectMapper projectMapper;
    private final JdbcTemplate jdbcTemplate;

    public ProjectDaoImpl(ProjectMapper projectMapper, JdbcTemplate jdbcTemplate) {
        this.projectMapper = projectMapper;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(Project item) {
        // userId, title, is_completed, start_date, finish_date
        jdbcTemplate.update(SQL_CREATE_PROJECT, item.getUserId(), item.getTitle(), item.isCompleted(), item.getStartDate(), item.getDeadlineDate());
    }

    @Override
    public void delete(Long itemId) {
        jdbcTemplate.update(SQL_DELETE_PROJECT, itemId);
    }

    @Override
    public void update(Project item) {
        Project notUpdated = findProject(item.getId()).get();
        if (item.isCompleted() != notUpdated.isCompleted()) {
            jdbcTemplate.update(SQL_UPDATE_PROJECT_IS_COMPLETED, item.isCompleted(), item.getId());
        }
        if (!item.getTitle().equals(notUpdated.getTitle())) {
            jdbcTemplate.update(SQL_UPDATE_PROJECT_TITLE, item.getTitle(), item.getId());
        }
    }

    @Override
    public Optional<List<Project>> findProjectsLinkedToUser(Long userId) {
        try {
            return Optional.ofNullable(jdbcTemplate.query(SQL_SELECT_BY_USER_ID, projectMapper, userId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
//        List<Project> res = jdbcTemplate.query(SQL_SELECT_BY_USER_ID, projectMapper, userId);
//        return Optional.of(res);
    }

    @Override
    public Optional<Project> findProject(Long projectId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, projectMapper, projectId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
//        Project res = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, projectMapper, projectId);
//        return Optional.ofNullable(res);
    }

    @Override
    public void deleteAll(Long userId) {
        jdbcTemplate.update(SQL_DELETE_PROJECT, userId);
    }
}
