package repository;

import model.Project;
import model.ProjectItem;

import java.util.List;
import java.util.Optional;

public interface ProjectItemDao extends GeneralDao<ProjectItem> {
    Optional<List<ProjectItem>> findProjectsLinkedToProject(long projectId);
    Optional<ProjectItem> findProjectItem(long projectItemId);
}
