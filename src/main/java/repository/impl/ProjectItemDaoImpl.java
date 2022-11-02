package repository.impl;

import exceptions.LoadingDbException;
import model.ProjectItem;
import repository.ProjectItemDao;

import java.util.List;
import java.util.Optional;

public class ProjectItemDaoImpl implements ProjectItemDao {
    @Override
    public void insert(ProjectItem item) throws LoadingDbException {

    }

    @Override
    public void delete(ProjectItem item) throws LoadingDbException {

    }

    @Override
    public void update(ProjectItem item) throws LoadingDbException {

    }

    @Override
    public Optional<List<ProjectItem>> findProjectsLinkedToProject(long projectId) {
        return Optional.empty();
    }
}
