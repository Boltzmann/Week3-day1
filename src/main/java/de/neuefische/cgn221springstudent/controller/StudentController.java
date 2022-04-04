package de.neuefische.cgn221springstudent.controller;

import de.neuefische.cgn221springstudent.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @GetMapping
    public List<Student> getAllStudents(){
        return List.of(new Student("0815", "Emily"), new Student("42", "Lennard"));
    }
}



