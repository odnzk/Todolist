package repository.dao;

import model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao extends CrudDao<Project> {
    void deleteAll(Long userId);

    Optional<List<Project>> findProjectsLinkedToUser(Long userId);

}
