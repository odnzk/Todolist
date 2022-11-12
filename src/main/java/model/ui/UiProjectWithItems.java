package model.ui;

import model.Project;
import model.ProjectItem;

import java.util.List;
import java.util.Objects;

public class UiProjectWithItems {
    private Project project;
    private List<ProjectItem> listProjectItem;
    private int progress;

    public UiProjectWithItems(Project project, List<ProjectItem> listProjectItem, int progress) {
        this.project = project;
        this.listProjectItem = listProjectItem;
        this.progress = progress;
    }

    public UiProjectWithItems() {
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UiProjectWithItems that = (UiProjectWithItems) o;
        return progress == that.progress && Objects.equals(project, that.project) && Objects.equals(listProjectItem, that.listProjectItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, listProjectItem, progress);
    }

    @Override
    public String toString() {
        return "UiProjectWithItems{" +
                "project=" + project +
                ", listProjectItem=" + listProjectItem +
                ", progress=" + progress +
                '}';
    }
}
