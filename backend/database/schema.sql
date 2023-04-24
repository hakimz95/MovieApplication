use railway;

drop table if exists user;
create table user ( 
	id varchar(8) not null,
    username varchar(32) not null unique,
    email varchar(128) not null unique,
    password varchar(128) not null,
    date_created date not null,
    
    primary key(username)
);