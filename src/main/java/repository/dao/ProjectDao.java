package repository.dao;

import model.Project;

import java.util.List;
import java.util.Optional;

// PROJECT_DAO find projects by id ( userId : Long ) : Optional<List<Project>>
public interface ProjectDao {
    void insert(Project item);

    void delete(Long itemId);

    void update(Project item);

    Optional<Project> findProject(Long projectId);

    void deleteAll(Long userId);

    Optional<List<Project>> findProjectsLinkedToUser(Long userId);

}
