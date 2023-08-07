package com.tjetc.model.view;

import com.tjetc.entity.MyClass;
import com.tjetc.entity.Student;

public class StudentAndMyClass {
    private Student student;
    private MyClass myClass;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public MyClass getMyClass() {
        return this.myClass;
    }

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public String toString() {
        return "StudentAndMyClass{" +
                "student=" + student +
                ", myClass=" + myClass +
                '}';
    }
}
