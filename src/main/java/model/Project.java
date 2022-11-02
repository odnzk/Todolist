package model;

import java.util.Date;
import java.util.Set;

public class Project {
    private Long id;
    private String title;
    private Set<Integer> projectItemIds;
    private boolean isCompleted;
    private Date startDate; //Date startDate (to count time until deadline)
    private Date deadlineDate;

    public Project(String title, Set<Integer> projectItemIds, boolean isCompleted, Date startDate, Date deadlineDate) {
        this.title = title;
        this.projectItemIds = projectItemIds;
        this.isCompleted = isCompleted;
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

    public Set<Integer> getProjectItemIds() {
        return projectItemIds;
    }

    public void setProjectItemIds(Set<Integer> projectItemIds) {
        this.projectItemIds = projectItemIds;
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
