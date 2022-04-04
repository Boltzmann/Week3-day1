package de.neuefische.cgn221springstudent.services;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.repo.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepo repo = new StudentRepo();

    public void addStudent(Student student) {
        repo.addStudent(student);
    }

    public Student getStudentById(int id) {
        return repo.getStudentById(id);
    }
}
