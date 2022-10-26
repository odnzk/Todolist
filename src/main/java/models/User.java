package models;


import java.util.Date;
import java.util.Objects;
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
    private Set<Integer> linkedTodoGroupsId;
}


