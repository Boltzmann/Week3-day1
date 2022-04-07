package de.neuefische.cgn221springstudent.controller;

import de.neuefische.cgn221springstudent.model.Student;
import de.neuefische.cgn221springstudent.repo.StudentRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {


    Student student = new Student("666", "Student Immerda");
    Student student2 = new Student("42", "Student Auchda");

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient testClient;

    @BeforeEach
    void addToRepo(){
        testClient.post()
                .uri("http://localhost:" + port + "/student")
                .bodyValue(student)
                .exchange()
                .expectStatus().is2xxSuccessful();
        testClient.post()
                .uri("http://localhost:" + port + "/student")
                .bodyValue(student2)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void addStudentTest() {
        // Given
        Student student = new Student("123", "Max Mustermann");
        // When
        testClient.post()
                .uri("http://localhost:" + port + "/student")
                .bodyValue(student)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void getStudentByIdTest() {
        // Given
        // When
        Student actual = testClient.get()
                .uri("/student/666")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Student.class)
                .returnResult()
                .getResponseBody();
        // Then
        Student expected = new Student("666", "Student Immerda");
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    void clearRepo(){
        // Todo
    }
}