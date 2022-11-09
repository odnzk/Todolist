package repository.impl;

import model.ProjectItem;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.dao.ProjectItemDao;
import util.jdbc.mapper.ProjectItemMapper;

import java.util.List;
import java.util.Optional;

public class ProjectItemDaoImpl implements ProjectItemDao {
    private static final String SQL_CREATE_PROJECT_ITEM = "insert into project_items(projectId, title, is_completed) values (?, ?, ?);";
    private static final String SQL_DELETE_PROJECT_ITEM = "delete from project_items where id = ?";
    private static final String SQL_SELECT_BY_ID = "select * from project_items where id = ? limit 1";
    private static final String SQL_SELECT_BY_PROJECT_ID = "select * from project_items where projectId = ?";
    private static final String SQL_COUNT_ALL = "select count(*) from project_items";

    private static final String SQL_UPDATE_PROJECT_ITEM_IS_COMPLETED = "update project_items set is_completed = ? where id=?;";


    private final ProjectItemMapper projectItemMapper;
    private final JdbcTemplate jdbcTemplate;

    public ProjectItemDaoImpl(ProjectItemMapper projectItemMapper, JdbcTemplate jdbcTemplate) {
        this.projectItemMapper = projectItemMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(ProjectItem item) {
        // projectId, title, is_completed
        jdbcTemplate.update(SQL_CREATE_PROJECT_ITEM, item.getProjectId(), item.getTitle(), item.isDone());
    }

    @Override
    public void delete(Long itemId) {
        jdbcTemplate.update(SQL_DELETE_PROJECT_ITEM, itemId);
    }

    @Override
    public void update(ProjectItem item) {
        ProjectItem notUpdated = findItem(item.getId()).get();
        jdbcTemplate.update(SQL_UPDATE_PROJECT_ITEM_IS_COMPLETED, !notUpdated.isDone(), item.getId());
    }

    @Override
    public Optional<ProjectItem> findItem(Long itemId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, projectItemMapper, itemId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public void update(Long itemId) {
        ProjectItem notUpdated = findItem(itemId).get();
        jdbcTemplate.update(SQL_UPDATE_PROJECT_ITEM_IS_COMPLETED, !notUpdated.isDone(), itemId);
    }

    @Override
    public Optional<Long> count() {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_COUNT_ALL, Long.class));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<ProjectItem>> findProjectItemsLinkedToProject(Long projectId) {
        try {
            return Optional.of(jdbcTemplate.query(SQL_SELECT_BY_PROJECT_ID, projectItemMapper, projectId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


}
