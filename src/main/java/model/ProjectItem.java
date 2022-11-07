package model;

public class ProjectItem {
    private Long id;
    private Long projectId;
    private String title;
    private boolean isCompleted;

    public ProjectItem(Long id, Long projectId, String title, boolean isCompleted) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
