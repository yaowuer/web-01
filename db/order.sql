create table dingdan
(
    id        integer primary key autoincrement,
    username  varchar(50)  not null,
    phone     varchar(50)  not null,
    addr      varchar(100) not null,
    create_at datetime,
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
    ddid   integer not null references dingdan (id),
    bookid integer not null references book (id),
    amount integer default 1
);
