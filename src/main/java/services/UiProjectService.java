package services;

import model.Project;
import model.ProjectItem;
import model.User;
import model.ui.UiProjectWithItems;
import repository.ProjectDao;
import repository.ProjectItemDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class UiProjectService {
    private final ProjectDao projectDao;
    private final ProjectItemDao projectItemDao;

    public UiProjectService(ProjectDao projectDao, ProjectItemDao projectItemDao) {
        this.projectDao = projectDao;
        this.projectItemDao = projectItemDao;
    }

    public List<UiProjectWithItems> getAllUiProjects(User user) {
        List<UiProjectWithItems> uiProjects = new java.util.ArrayList<>(List.of());

        List<Project> projectList = projectDao.findProjectsLinkedToUser(user.getId()).orElse(List.of());
        for (Project project : projectList) {
            List<ProjectItem> items = projectItemDao.findProjectsLinkedToProject(project.getId()).orElse(List.of());
            items = items
                    .stream()
                    .filter(item -> !item.isCompleted())
                    .collect(Collectors.toList());
            uiProjects.add(new UiProjectWithItems(project, items));
        }

        uiProjects.sort((o1, o2) -> -Boolean.compare(o1.getProject().isCompleted(),
                o2.getProject().isCompleted()));

        return uiProjects;
    }

    // details fragment
    public UiProjectWithItems getUiProject(long projectId) {
        UiProjectWithItems uiProject = new UiProjectWithItems();
        Project project = projectDao.findProject(projectId).orElseThrow();
        List<ProjectItem> items = projectItemDao.findProjectsLinkedToProject(project.getId()).orElse(List.of());
        // sort completed first
        items.sort(new Comparator<ProjectItem>() {
            @Override
            public int compare(ProjectItem o1, ProjectItem o2) {
                return Boolean.compare(o1.isCompleted(), o2.isCompleted());
            }
        });
        uiProject.setProject(project);
        uiProject.setListProjectItem(items);

        return uiProject;
    }
}
