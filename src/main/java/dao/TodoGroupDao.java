package dao;

import models.Todo;
import models.TodoGroup;

import java.util.List;
import java.util.Optional;

public interface TodoGroupDao extends GeneralDao<TodoGroup>{
    Optional<Todo> findTodoGroupById(Long id); // to fund by id for Todo
}
