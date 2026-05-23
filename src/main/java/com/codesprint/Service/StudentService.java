package com.codesprint.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesprint.entity.Student;
import com.codesprint.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getStudentByEmail(String email) {

        return studentRepository.findByEmail(email);
    }

}