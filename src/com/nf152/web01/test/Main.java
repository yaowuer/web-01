package com.nf152.web01.test;

import com.nf152.web01.bean.Book;
import com.nf152.web01.bean.Student;
import com.nf152.web01.dao.BookDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        bookDAO.delete(4);
    }
}
