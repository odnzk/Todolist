package services;

import model.ProjectItem;
import repository.impl.ProjectItemDaoImpl;

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
}
