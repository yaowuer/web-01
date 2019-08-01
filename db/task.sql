create table task
(
    id integer primary key autoincrement ,
    content varchar(100) not null,
    status char(1)
);

select * from task;

update task set status = 9 where id > 35;

delete from task;