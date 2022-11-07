package services;

import model.Project;
import model.ProjectItem;
import model.User;
import model.ui.UiProjectWithItems;
import repository.ProjectDao;
import repository.ProjectItemDao;
import repository.impl.ProjectDaoImpl;
import repository.impl.ProjectItemDaoImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class UiProjectService {
    private User user;
    private ProjectDao projectDao = new ProjectDaoImpl();
    private ProjectItemDao projectItemDao = new ProjectItemDaoImpl();

    public UiProjectService(User user) {
        this.user = user;
    }

    public List<UiProjectWithItems> getAllUiProjects() {
        List<UiProjectWithItems> uiProjects = List.of();

        List<Project> projectList = projectDao.findProjectsLinkedToUser(user.getId()).orElse(List.of());
        for (Project project : projectList) {
            List<ProjectItem> items = projectItemDao.findProjectsLinkedToProject(project.getId()).orElse(List.of());
            // filter !isCompleted
            items = items.stream().filter(item -> !item.isCompleted()).collect(Collectors.toList());
            uiProjects.add(new UiProjectWithItems(project, items));
        }

        // sort active first
        uiProjects.sort(new Comparator<UiProjectWithItems>() {
            @Override
            public int compare(UiProjectWithItems o1, UiProjectWithItems o2) {
                // true == true, false == false
                // true < false
                return -Boolean.compare(o1.getProject().isCompleted(), o2.getProject().isCompleted());
//                int p1 = o1.getProject().isCompleted() ? 0 : 1;
//                int p2 = o2.getProject().isCompleted() ? 0 : 1;
//                return p1 - p2;
            }
        });

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
                // want true > false
                // compare to
                return Boolean.compare(o1.isCompleted(), o2.isCompleted());
            }
        });
        uiProject.setProject(project);
        uiProject.setListProjectItem(items);

        return uiProject;
    }
}
