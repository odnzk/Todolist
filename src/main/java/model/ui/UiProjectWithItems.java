package model.ui;

import model.Project;
import model.ProjectItem;

import java.util.List;

public class UiProjectWithItems {
    private Project project;
    private List<ProjectItem> listProjectItem;

    public UiProjectWithItems(Project project, List<ProjectItem> listProjectItem) {
        this.project = project;
        this.listProjectItem = listProjectItem;
    }

    public UiProjectWithItems() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<ProjectItem> getListProjectItem() {
        return listProjectItem;
    }

    public void setListProjectItem(List<ProjectItem> listProjectItem) {
        this.listProjectItem = listProjectItem;
    }
}
