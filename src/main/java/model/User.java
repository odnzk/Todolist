package model;


import java.util.Collections;
import java.util.Set;

//create table users
//        (
//        user_id bigserial primary key,
//        username varchar(20) NOT NULL,
//        email text NOT NULL,
//        country text NOT NULL,
//        date timestamp default NULL,
//        sex boolean NOT NULL,
//        password text NOT NULL
//        );

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<Integer> projectIds = Collections.emptySet();


    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(Set<Integer> projectIds) {
        this.projectIds = projectIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


