package services;

import model.Project;
import model.ProjectItem;
import model.User;
import model.ui.UiProjectWithItems;
import repository.dao.ProjectDao;
import repository.dao.ProjectItemDao;

import java.util.Comparator;
import java.util.List;


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
            List<ProjectItem> items = projectItemDao.findProjectItemsLinkedToProject(project.getId()).orElse(List.of());
            long countItems = items.size();
            items.sort(new Comparator<ProjectItem>() {
                @Override
                public int compare(ProjectItem o1, ProjectItem o2) {
                    return -Boolean.compare(o1.isDone(), o2.isDone());
                }
            });
            long countCompleted = items.stream().map(ProjectItem::isDone).filter(it -> it).count();
            int progress = (int) (countCompleted * 100.0 / countItems);
            uiProjects.add(new UiProjectWithItems(project, items, progress));
        }

        uiProjects.sort((o1, o2) -> -Boolean.compare(o1.getProject().isCompleted(),
                o2.getProject().isCompleted()));

        return uiProjects;
    }
}
