package services;

import model.ProjectItem;
import repository.impl.ProjectItemDaoImpl;

import java.util.List;
import java.util.Optional;

public class ProjectItemService {
    private final ProjectItemDaoImpl projectItemDao;

    public ProjectItemService(ProjectItemDaoImpl projectItemDao) {
        this.projectItemDao = projectItemDao;
    }

    public void add(ProjectItem item) {
        projectItemDao.insert(item);
    }

    public void update(Long itemId) {
        projectItemDao.update(itemId);
    }

    public void delete(Long itemId){
        projectItemDao.delete(itemId);
    }

    public Optional<Long> countAll() {
        return projectItemDao.count();
    }

    public Optional<List<ProjectItem>> findProjectItemsLinkedToProjectByProjectItem(Long projectItemId) {
        Optional<ProjectItem> projectItem = projectItemDao.findItem(projectItemId);
        if(projectItem.isPresent()){
            Long projectId = projectItem.get().getProjectId();
            return projectItemDao.findProjectItemsLinkedToProject(projectId);
        }
        return Optional.empty();
    }

}
