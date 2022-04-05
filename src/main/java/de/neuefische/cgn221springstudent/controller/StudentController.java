package de.neuefische.cgn221springstudent.controller;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService service = new StudentService();

    @RequestMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable String id) {
        return service.getStudentById(id);
    }

    @GetMapping(path = "/name/{partOfName}")
    public List<Student> getStudentsByPartOfName(@PathVariable String partOfName) {
        return service.getStudentsByPartOfName(partOfName);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void delStudentById(@PathVariable String id) {
        service.delStudentById(id);
    }


}



