package de.neuefische.cgn221springstudent.repo;

import de.neuefische.cgn221springstudent.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {
    @Test
    public void clearRepoTest(){
        // Given
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.addStudent(new Student("666", "Student from hell"));
        Student tmp_expected = new Student("666", "Student from hell");
        Assertions.assertEquals(tmp_expected, studentRepo.getStudentById("666"));
        // When
        studentRepo.clear();
        List<Student> expect = new ArrayList<>();

        Assertions.assertEquals(expect, studentRepo.getAllStudentsAsList());
    }
}