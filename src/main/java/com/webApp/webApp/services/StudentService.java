package com.webApp.webApp.services;

import com.webApp.webApp.repository.StudentRepository;
import com.webApp.webApp.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.selectAllStudents();
    }
}
