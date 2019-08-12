-- auto-generated definition
create table username
(
    username varchar(32) default '' not null
        primary key,
    password varchar(64)            null,
    nickname varchar(63)            null
);

