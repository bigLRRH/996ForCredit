package com.tjetc.controller;

import com.tjetc.common.ImageInfo;
import com.tjetc.entity.MyClass;
import com.tjetc.entity.Student;
import com.tjetc.model.view.StudentAndMyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping用在类上表示 与方法上@RequestMapping的值进行拼接组成一个url映射
@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private Student student;

    @Autowired
    private MyClass myClass;

    @Autowired
    private ImageInfo imageInfo;

    @RequestMapping(value = "/info",method = {RequestMethod.GET,RequestMethod.POST})
    public Student info(){
        return student;
    }

    @RequestMapping(value = "/stAndMyClassInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public StudentAndMyClass stAndMyClassInfo(){
        StudentAndMyClass studentAndMyClass = new StudentAndMyClass();
        studentAndMyClass.setStudent(student);
        studentAndMyClass.setMyClass(myClass);
        return studentAndMyClass;
    }

    @RequestMapping(value = "/imageInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public ImageInfo imageInfo(){
        return imageInfo;
    }
}
