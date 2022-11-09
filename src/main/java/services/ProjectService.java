package services;

import model.Project;
import repository.dao.ProjectDao;

import java.util.List;
import java.util.Optional;

public class ProjectService {
    private final ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void create(Project item) {
        projectDao.insert(item);
    }

    public void delete(Project item) {
        projectDao.delete(item);
    }

    public void deleteAll(long userId) {
        projectDao.deleteAll(userId);
    }

    public void update(Project item) {
        projectDao.update(item);
    }

    public Optional<List<Project>> getUserProject(long userId) {
        return projectDao.findProjectsLinkedToUser(userId);
    }

    public Optional<Project> getProject(long projectId) {
        return projectDao.findProject(projectId);
    }
}
