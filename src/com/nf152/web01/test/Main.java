package com.nf152.web01.test;

import com.nf152.web01.bean.Book;
import com.nf152.web01.bean.Student;
import com.nf152.web01.util.DBUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        int count = DBUtil.execute("insert into admin (name, author, publisher) values (?, ?, ?)"
//                                         , "战争与和平", "托尔斯泰", "看的房间打开");
//
//        int count = DBUtil.execute("delete from admin where id = ?", 5);
//        System.out.println(count);

        List<Book> books = DBUtil.queryList(Book.class, "select * from admin");
        System.out.println(books.size());

        List<Student> students = DBUtil.queryList(Student.class, "select * from student");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
