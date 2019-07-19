create table account
(
    username varchar(50) primary key,
    password varchar(50) not null,
    type integer default 1
);

insert into account values
    ('admin', 'admin', 9),
    ('guanliyuan', '12345678', 9);

select * from account;