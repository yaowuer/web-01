create table comment
(
    id integer primary key autoincrement,
    content varchar(500)
);


insert into comment (content) values ('真好');

select count(*) from comment;

delete from comment;