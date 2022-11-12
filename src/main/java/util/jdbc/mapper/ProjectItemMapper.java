package util.jdbc.mapper;

import model.ProjectItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectItemMapper implements RowMapper<ProjectItem> {

    @Override
    public ProjectItem mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        Long projectId = resultSet.getLong("projectid");
        String title = resultSet.getString("title");
        boolean isCompleted = resultSet.getBoolean("is_completed");
        return new ProjectItem(id, projectId, title, isCompleted);
    }
}
