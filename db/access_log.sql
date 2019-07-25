create table access_log
(
    id integer primary key autoincrement,
    account varchar(50),
    ip varchar(20),
    ua varchar(100),
    url varchar(100),
    access_at varchar(100)
);

select  * from access_log;