create table task
(
    id integer primary key autoincrement ,
    content varchar(100) not null,
    status char(1)
);

select * from task;

delete from task;