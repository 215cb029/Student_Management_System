package com.studentmanagement.StudentManagementSystem.service.impl;

import com.studentmanagement.StudentManagementSystem.dao.StudentRepository;
import com.studentmanagement.StudentManagementSystem.model.Student;
import com.studentmanagement.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Impl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return  studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
         studentRepository.deleteById(id);
    }

    @Override
    public Student findStudent(long id) {
       return studentRepository.findById(id).get();

    }

    @Override
    public Student updateStudent(long id,Student student) {
       Student st= studentRepository.findById(id).get();
       st.setFirstName(student.getFirstName());
       st.setLastName(student.getLastName());
       st.setEmail(student.getEmail());
       return studentRepository.save(st);

    }
}
