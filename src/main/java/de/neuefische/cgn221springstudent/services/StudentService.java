package de.neuefische.cgn221springstudent.services;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepo repo = new StudentRepo();

    public void addStudent(Student student) {
        repo.addStudent(student);

    }

    public Student getStudentById(String id) {
        return repo.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudentsAsList();
    }

    public void delStudentById(String id) {
        repo.delStudentById(id);
    }


    public List<Student> getStudentsByPartOfName(String partOfName) {
        return repo.getStudentsByPartOfName(partOfName);
    }
}
