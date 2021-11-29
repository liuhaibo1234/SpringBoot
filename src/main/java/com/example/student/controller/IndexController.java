package com.example.student.controller;

import com.example.student.api.dto.Student;
import com.example.student.api.service.StudentService;
import com.example.student.aspect.InsertLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class IndexController {

    @Autowired
    private StudentService studentService;
    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }
    @PostMapping("/addStudent")
    public int addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PostMapping("/selectStudent")
    @InsertLog
    public List<Student> selectStudent(@RequestBody Student student){
        return studentService.selectStudent(student);
    }

}
