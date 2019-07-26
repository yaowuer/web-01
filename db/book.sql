-- 书籍 (books)
create table book
(
    id         integer primary key autoincrement, -- 代理主键，不是自然主键
    name       varchar(50) not null,              -- 书名，经常创建表的时候，会顺手加约束
    author     varchar(50) not null,              -- 作者，实际上应该单独成表
    publisher  varchar(100),                      -- 出版社，按照道理，应该可以为空。约束是为了防止粗心大意
    price      float       not null default 10,   -- 价格。使用 default 给与默认值
    amount     integer              default 1,    -- 剩余库存
    publish_at publishAt
);
-- d:/aaa/xxx.jpg
alter table book add cover varchar(50);

insert into book
    (name, author, publisher, price, publish_at)
values ('Think in Java', 'Erik', 'xinhuachubanshe', 98, '2009-11-12'),
       ('Think in JQuery', 'Ni', 'xinhuachubanshe', 58, '2011-11-12'),
       ('Think in CSS', 'Ni', 'xinhuachubanshe', 18, '2019-11-12'),
       ('Think in Life', 'Wo', 'xinhuachubanshe', 298, '2029-11-12');

-- 处理自增的时候，每种数据库的写法是不一样的。identity，身份
select * from book order by id desc;