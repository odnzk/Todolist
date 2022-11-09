package services;

import model.ProjectItem;
import repository.dao.ProjectItemDao;

public class ProjectItemService {
    private final ProjectItemDao projectItemDao;

    public ProjectItemService(ProjectItemDao projectItemDao) {
        this.projectItemDao = projectItemDao;
    }

    public void add(ProjectItem item){
        projectItemDao.insert(item);
    }
}
