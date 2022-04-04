package de.neuefische.cgn221springstudent.repo;

import de.neuefische.cgn221springstudent.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepo {
    Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId() ,student);
    }
    public Student getStudentById (String id){
       return students.get(id);
    }

}
