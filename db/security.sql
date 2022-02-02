create table url (
    id serial primary key not null,
    link varchar(2000),
    url varchar(2000),
    count integer
);

create table site (
    id serial primary key not null,
    site varchar(2000),
    login varchar(2000),
    password varchar(2000)
);