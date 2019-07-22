create table dingdan
(
    id varchar2(100) primary key,
    account   varchar(50) not null,
    receiver  varchar(50)  not null,
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

select * from dingdan order by create_at desc;
select * from dingdan_xijie;


select * from dingdan where account = 'tomcat';
select * from dingdan_xijie where ddid = '9f50c3b9-ce87-411e-a5e3-f20e22d441ea';

select b.*, d.amount shumu from dingdan_xijie d join book b on d.bookid = b.id
                                                    where ddid = '9f50c3b9-ce87-411e-a5e3-f20e22d441ea';