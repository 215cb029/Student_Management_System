package com.studentmanagement.StudentManagementSystem.service;

import com.studentmanagement.StudentManagementSystem.dao.StudentRepository;
import com.studentmanagement.StudentManagementSystem.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
     Student saveStudent(Student student);

     void deleteStudent(long id);
     Student findStudent(long id);

     Student updateStudent(long id,Student student);
}
