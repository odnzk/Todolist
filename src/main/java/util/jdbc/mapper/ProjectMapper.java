package util.jdbc.mapper;

import model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        Long userid = resultSet.getLong("userid");
        String title = resultSet.getString("title");
        Boolean isCompleted = resultSet.getBoolean("is_completed");
        Date startDate = resultSet.getDate("start_date");
        Date finishDate = resultSet.getDate("finish_date");
        return new Project(id, userid, title, isCompleted, startDate, finishDate);
    }
}
