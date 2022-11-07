package util;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate {

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... objects) throws LoadingDbException {
        List<T> reslist = new ArrayList<>();
        try(Connection conn = AppDatabase.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ){
            int position = 1;
            for (Object obj : objects) {
                preparedStatement.setObject(position++, obj);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                int pos = 1;
                if(resultSet != null) {
                    while (resultSet.next()){
                        reslist.add(rowMapper.mapRow(resultSet, pos));
                        pos++;
                    }
                }
            }
        } catch (SQLException|ConnectingDbException e) {
            throw new LoadingDbException("Connecting to db error");
        }
        return reslist;
    }

    public int update(String sql, Object... objects) throws LoadingDbException {
        int id = -1;
        try (Connection conn = AppDatabase.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            int position = 1;
            for (Object obj : objects) {
                preparedStatement.setObject(position++, obj);
            }
            preparedStatement.execute();

            try {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new LoadingDbException("Connecting to db error");
            }

        } catch (SQLException|ConnectingDbException ex) {
            throw new LoadingDbException("Connecting to db error");
        }
        return id;
    }

}
