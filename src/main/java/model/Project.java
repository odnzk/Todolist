package model;

import java.util.Date;
import java.util.Set;

public class Project {
    private Long id;
    private Long userId;
    private String title;
    private boolean isCompleted;
    private Date startDate;
    private Date deadlineDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Project(Long id, Long userId, String title, boolean isCompleted, Date startDate, Date deadlineDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.isCompleted = isCompleted;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
    }

    public Project(Long userId, String title, Date startDate, Date deadlineDate) {
        this.userId = userId;
        this.title = title;
        this.isCompleted = false;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
