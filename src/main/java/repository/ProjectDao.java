package repository;

import model.Project;
import model.ProjectItem;

import java.util.List;
import java.util.Optional;

// PROJECT_DAO find projects by id ( userId : Long ) : Optional<List<Project>>
public interface ProjectDao extends GeneralDao<Project>{
    Optional<List<Project>> findProjectsLinkedToUser(long userId);

    Optional<Project> findProject(long projectId);
}
