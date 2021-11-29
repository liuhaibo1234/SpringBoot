package com.example.student.api.service;

import com.example.student.api.dto.Student;

import java.util.List;

public interface StudentService {
    public int addStudent(Student student);

    List<Student> selectStudent(Student student);
}
