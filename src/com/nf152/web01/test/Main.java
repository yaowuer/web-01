package com.nf152.web01.test;

import com.nf152.web01.bean.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tom");
        student.setScore(66);
        student.setWeixin("110");

        System.out.println(student);
    }
}
