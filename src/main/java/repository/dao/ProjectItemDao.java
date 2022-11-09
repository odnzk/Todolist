package repository.dao;

import model.ProjectItem;

import java.util.List;
import java.util.Optional;

public interface ProjectItemDao {
    void insert(ProjectItem item);
    void delete(Long itemId);
    void update(Long itemId);
    Optional<List<ProjectItem>> findProjectsLinkedToProject(Long projectId);
    Optional<ProjectItem> findProjectItem(Long projectItemId);
}
