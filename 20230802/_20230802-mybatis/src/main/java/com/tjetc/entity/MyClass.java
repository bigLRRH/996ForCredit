package com.tjetc.entity;

import java.util.List;

public class MyClass {
    private int id;
    private String name;
    //    定义学生集合对象
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name=" + name +
                ", students=" + students +
                '}';
    }
}
