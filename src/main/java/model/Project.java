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
}
