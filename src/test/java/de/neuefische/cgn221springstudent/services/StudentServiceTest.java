package de.neuefische.cgn221springstudent.services;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}