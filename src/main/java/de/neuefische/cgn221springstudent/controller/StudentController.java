package de.neuefische.cgn221springstudent.controller;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService service = new StudentService();

    @GetMapping(path ="{id}")
   public Student getStudentById (@PathVariable String id){
        return service.getStudentById(id);
    }

    @GetMapping(path ="all")
    public Map <String, Student> getAllStudents (){
        return service.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @PostMapping(path="delete"+"{id}")
    public void deleteStudentById(@RequestBody String id){
        service.deleteStudentByID(id);
    }
}



