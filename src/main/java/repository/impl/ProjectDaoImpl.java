package repository.impl;

import exceptions.LoadingDbException;
import model.Project;
import repository.ProjectDao;

import java.util.List;
import java.util.Optional;

public class ProjectDaoImpl implements ProjectDao {
    @Override
    public void insert(Project item) throws LoadingDbException {

    }

    @Override
    public void delete(Project item) throws LoadingDbException {

    }

    @Override
    public void update(Project item) throws LoadingDbException {

    }

    @Override
    public Optional<List<Project>> findProjectsLinkedToUser(long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findProject(long projectId) {
        return Optional.empty();
    }
}
