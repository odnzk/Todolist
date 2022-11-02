package util;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate {

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... objects) throws LoadingDbException {
        List<T> resList = new ArrayList<>();
        try (Connection connection = AppDatabase.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(sql)) {
            int position = 1;
            for (Object obj : objects) {
                prepStatement.setObject(position, obj);
                position++;
            }
            ResultSet resultSet = prepStatement.executeQuery();
            if (resultSet != null) {
                int pos = 1;
                while (resultSet.next()) {
                    resList.add(rowMapper.mapRow(resultSet, pos));
                    pos++;
                }
            }
        } catch (SQLException | ConnectingDbException e) {
            throw new LoadingDbException("Connection to db failed while querying mes: " + e.getMessage());
        }
        return resList;
    }

    public int update(String sql, Object... objects) throws LoadingDbException {
        int id = -1;
        try (Connection connection = AppDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            int position = 1;
            for (Object obj : objects) {
                preparedStatement.setObject(position++, obj);
            }
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException | ConnectingDbException e) {
            throw new LoadingDbException("Connection to db failed while updating  mes: " + e.getMessage());
        }
        return id;
    }

}
