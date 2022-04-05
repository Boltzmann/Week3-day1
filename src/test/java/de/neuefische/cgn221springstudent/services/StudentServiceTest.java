package de.neuefische.cgn221springstudent.services;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class StudentServiceTest {

    private final StudentRepo studentRepo = mock(StudentRepo.class);
    private final StudentService myTestService = new StudentService(studentRepo);

    @Test
    void getStudentById() {
        // Given
        when(studentRepo.getStudentById("1")).thenReturn(new Student("1", "Frau Muster"));
        // When
        Student expect = new Student("1", "Frau Muster");
        // Then
        Student actual = myTestService.getStudentById("1");

        verify(studentRepo).getStudentById("1");
        Assertions.assertEquals(expect, actual);
    }

    @Test
    void addStudent() {
        // Given done before.
        // When
        myTestService.addStudent(new Student("1", "Mister Muster"));
        // Then
        verify(studentRepo).addStudent(new Student("1", "Mister Muster"));
    }

    @Test
    void getAllStudents() {
        // Given
        List<Student> studentList = new ArrayList<>(List.of(
                new Student("1", "Mister Muster"),
                new Student("2", "Frau Muster"))
        );
        when(studentRepo.getAllStudentsAsList()).thenReturn(studentList);
        // When - redundant: expect List similar to studentList.
        // Then
        List<Student> actual = myTestService.getAllStudents();
        Assertions.assertEquals(studentList, actual);
    }


}