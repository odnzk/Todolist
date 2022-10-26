package models;

import java.util.Date;
import java.util.Set;

public class TodoGroup {
    private Long id;
    private String title;
    private Set<Integer> linkedTodosGroupsId;
    private boolean isCompleted;
    private Date startDate; //Date startDate (to count time until deadline)
    private Date deadlineDate;
}
