package com.tjetc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component//生成bean对象交给springboot容器管理
//@configurationProperties可以读取主配置文件格式为：yaml和properties
@ConfigurationProperties(
        prefix = "student"//把读取主配置文件中的数据赋值给student对象
)
//需要属性，指定主配置文件中的数据，属性名称要与配置文件中key名称保持一致
public class Student {
    private String studentName;
    private Integer age;
    private Boolean sex;//男代表true
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Book book;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", book=" + book +
                '}';
    }
}
