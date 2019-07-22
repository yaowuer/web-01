package com.nf152.web01.bean.book;

import com.nf152.web01.bean.Account;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Account account;
    private String receiver;
    private String phone;
    private String addr;
    private Integer status;

    private Map<Book, Integer> orderDetail = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Map<Book, Integer> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Map<Book, Integer> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
