package com.example.student.support;

import com.example.student.api.dto.Student;
import com.example.student.api.service.StudentService;
import com.example.student.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public List<Student> selectStudent(Student student) {
        return studentDao.selectStudentList(student);
    }
}
