package model.ui;

import model.Project;
import model.ProjectItem;

import java.util.List;

public class UiProjectWithItems {
    private Project project;
    private List<ProjectItem> listProjectItem;
    private int progress;

    public UiProjectWithItems(Project project, List<ProjectItem> listProjectItem, int progress) {
        this.project = project;
        this.listProjectItem = listProjectItem;
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
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
