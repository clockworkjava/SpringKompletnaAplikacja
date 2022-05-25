CREATE TABLE USERS (
    id bigint not null auto_increment,
    username varchar(255),
    password varchar(255),
    primary key (id)
);

CREATE TABLE USERS_ROLES (user_id bigint not null, role varchar(255));

ALTER TABLE USERS_ROLES ADD constraint FK8m7edvc6gfyryjnssxluj5stv foreign key (user_id) references USERS(id);

insert into USERS (id, username, password) values (1, 'pawelcwik', '$2a$09$ubkul.r9iNId0PFeTgZ1ZOYwC6RWJHb5XkUYC2Jzcy8mJ9SJrYyoS');

insert into USERS_ROLES (user_id, role) values (1, 'MANAGER');

insert into USERS (id, username, password) values (2, 'ali', '$2a$09$rmtQ5G6xwMf7NhFt4lofae3u46sf3YCUGSQ3jW9CMzsxVOOE.kHe.');

