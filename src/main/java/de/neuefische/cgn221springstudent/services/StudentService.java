package de.neuefische.cgn221springstudent.services;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {
    StudentRepo repo = new StudentRepo();

    public void addStudent(Student student) {
        repo.addStudent(student);
    }

    public Student getStudentById(String id) {
        return repo.getStudentById(id);
    }

    public Map<String, Student> getAllStudents (){
        return repo.getAllStudents();
    }

    public void deleteStudentByID(String id){
        repo.deleteStudentById(id);
    }
}
