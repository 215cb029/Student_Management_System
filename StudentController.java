package com.studentmanagement.StudentManagementSystem.controller;

import com.studentmanagement.StudentManagementSystem.model.Student;
import com.studentmanagement.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public String studentList(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }
    @GetMapping("/students/new")
public String createStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student" ;
}
@PostMapping("/saveStudent")
public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
}
@GetMapping("/delete/{id}")
public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
return "redirect:/students";
}
@GetMapping("/update/{id}")
public String student(@PathVariable long id,Model model){
    Student student=studentService.findStudent(id);

        model.addAttribute("student", student);
        return "edit_student";


}

        @PostMapping("/updateStudent/{id}")
public String updateStudent(@PathVariable long id,@ModelAttribute Student student){
        studentService.updateStudent(id,student);
        return "redirect:/students";
}
}
