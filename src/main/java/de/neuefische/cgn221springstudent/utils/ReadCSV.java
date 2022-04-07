package de.neuefische.cgn221springstudent.utils;


import de.neuefische.cgn221springstudent.model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class ReadCSV {
    // https://stackoverflow.com/questions/4871051/how-to-get-the-current-working-directory-in-java
    private final String path = new File(".").getCanonicalPath() + "/students.csv";
    // Putting the file in src would be easier. Then no special path arguments are needed.

    public ReadCSV() throws IOException {}

    public static void main(String[] args) throws IOException {
        ReadCSV readCSV = new ReadCSV();
        readCSV.printAllLines();
        System.out.println("--- Now without Header ---");
        readCSV.printLinesWithoutHeader();
        System.out.println("--- Now list of Students ---");
        System.out.println(readCSV.getStudentsFromFile());
        System.out.println("--- Now only distinct Students ---");
        System.out.println(readCSV.getSingularStudentsFromFile());
    }

    private void printAllLines() throws IOException {
        Files.lines(Path.of(path))
                .forEach(student -> System.out.println(student));
    }

    private void printLinesWithoutHeader() throws IOException {
        Files.lines(Path.of(path))
                .skip(1)
                .forEach(student -> System.out.println(student));
    }

    private List<Student> getStudentsFromFile() throws IOException {
        // With a little help of
        // https://stackoverflow.com/a/51439995/1985423
        return Files.lines(Path.of(path))
                .skip(1)
                .filter(Predicate.not(String::isEmpty))
                .<Student>mapMulti((line, student) -> {String[] cols = line.split(","); student.accept(new Student(cols[0], cols[1]));})
                .toList();
    }

    private List<Student> getSingularStudentsFromFile() throws IOException {
        // With a little help of
        // https://stackoverflow.com/a/51439995/1985423
        return Files.lines(Path.of(path))
                .skip(1)
                .distinct()
                .filter(Predicate.not(String::isEmpty))
                .<Student>mapMulti((line, student) -> {String[] cols = line.split(","); student.accept(new Student(cols[0], cols[1]));})
                .toList();
    }


}
