package models;

import java.util.Set;

public class Todo {
    private Long id;
    private String title;
    private Set<Integer> linkedTodosGroupsId;
    private boolean isCompleted;
}
