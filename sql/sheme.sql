create table users
(
    id       bigserial
        constraint users_pk
            primary key,
    username varchar(30) not null,
    email    varchar(30),
    password varchar     not null
);

create unique index users_email_uindex
    on users (email);

create unique index users_id_uindex
    on users (id);

create table projects
(
    id           bigserial
        constraint projects_pk
            primary key,
    userId       int,
    title        text    not null,
    is_completed boolean not null,
    start_date   date,
    finish_date  date,

    foreign key (userId) references users (id) on delete cascade
);
insert into projects(userId, title, is_completed, start_date, finish_date)
values (?, ?, ?, ?, ?);

create unique index projects_id_uindex
    on projects (id);

create table project_items
(
    id           bigserial
        constraint project_items_pk
            primary key,
    projectId    int,
    title        text    not null,
    is_completed boolean not null,

    foreign key (projectId) references projects (id) on delete cascade
);

create unique index project_items_id_uindex
    on project_items (id);

drop table achievements;
create table achievements
(
    id    bigserial
        constraint achievements_pk
            primary key,
    title text not null
);

create unique index achievements_id_uindex
    on achievements (achievement_id);

create table _user_achievements
(
    userId        int     not null,
    achievementId int     not null,
    is_unlocked   boolean not null default true,

    foreign key (userId) references users (id),
    foreign key (achievementId) references achievements (achievement_id)
);
