package dao;

import models.Todo;
import models.User;

import java.util.List;
import java.util.Optional;

public interface TodoDao extends GeneralDao<Todo>{
    Optional<Todo> findTodoById(Long id); // to fund by id for TodoGroup
    Optional<List<Todo>> getAllTodosLinkedToTodosGroup(Long todoGroupId);
}
