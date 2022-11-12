package repository.dao;

import model.ProjectItem;

import java.util.List;
import java.util.Optional;

public interface ProjectItemDao extends CrudDao<ProjectItem> {
    Optional<Long> count();

    Optional<List<ProjectItem>> findProjectItemsLinkedToProject(Long projectId);
}
