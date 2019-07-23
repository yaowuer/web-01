package com.nf152.web01.bean.book;

public class Book {
    // id integer primary key autoincrement, -- 代理主键，不是自然主键
    private Integer id;

    // name varchar(50) not null,   -- 书名，经常创建表的时候，会顺手加约束
    private String name;

    // author varchar(50) not null, -- 作者，实际上应该单独成表
    private String author;

    // publisher varchar(100),      -- 出版社，按照道理，应该可以为空。约束是为了防止粗心大意
    private String publisher;

    // price float not null default 10, -- 价格。使用 default 给与默认值
    private Double price;

    // amount integer default 1,    -- 剩余库存
    private Integer amount;

    // publish_at publishAt
    private String publishAt;

    ///////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(String publishAt) {
        this.publishAt = publishAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", publishAt=" + publishAt +
                '}';
    }
}
