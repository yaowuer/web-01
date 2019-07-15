package com.nf152.web01.bean;

// 用来封装基本数据的类
// 只有属性和 get/set 方法的类
// 称作 Java Bean
public class Student {
    private Integer id;
    private String name;
    private String weixin;
    private Double score;

    public Student() {
    }

    public Student(Integer id, String name, String weixin, Double score) {
        this.id = id;
        this.name = name;
        this.weixin = weixin;
        this.score = score;
    }


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

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weixin='" + weixin + '\'' +
                '}';
    }
}
