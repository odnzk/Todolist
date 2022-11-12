package model;

import java.util.Objects;

public class ProjectItem {
    private Long id;
    private Long projectId;
    private String title;
    private boolean done;

    public ProjectItem(Long id, Long projectId, String title, boolean isDone) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.done = isDone;
    }

    public ProjectItem(Long projectId, String title) {
        this.done = false;
        this.projectId = projectId;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectItem that = (ProjectItem) o;
        return done == that.done && Objects.equals(id, that.id) && Objects.equals(projectId, that.projectId) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, title, done);
    }

    @Override
    public String toString() {
        return "ProjectItem{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", title='" + title + '\'' +
                ", done=" + done +
                '}';
    }
}
