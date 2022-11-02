package model;

public class ProjectItem {
    private Long id;
    private String title;
    private boolean isCompleted;

    public ProjectItem(String title, boolean isCompleted) {
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

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
