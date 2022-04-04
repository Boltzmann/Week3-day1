package de.neuefische.cgn221springstudent.controller;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService service = new StudentService();

    @GetMapping(path ="{id}")
   public Student getStudentById (@PathVariable String id){
        return service.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }
}



