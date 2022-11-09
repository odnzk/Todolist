package model;

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

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
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

}
