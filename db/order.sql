create table dingdan
(
    id varchar2(100) primary key,
    username  varchar(50)  not null,
    phone     varchar(50)  not null,
    addr      varchar(100) not null,
    create_at varchar(50),
    status    integer default 0
);

-- 1  1 1 3
-- 2  1 2 1
-- 3  2 3 199
-- 4  2 西瓜 2
-- 5  2 桃子 33
create table dingdan_xijie
(
    id     integer primary key autoincrement,
    ddid   varchar2(100) not null references dingdan (id),
    bookid integer not null references book (id),
    amount integer default 1
);

drop table dingdan;
drop table dingdan_xijie;
