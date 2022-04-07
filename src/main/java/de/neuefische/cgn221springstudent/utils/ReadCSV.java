package de.neuefische.cgn221springstudent.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadCSV {
    // https://stackoverflow.com/questions/4871051/how-to-get-the-current-working-directory-in-java
    private final String path = new File(".").getCanonicalPath() + "/students.csv";

    public ReadCSV() throws IOException {}

    public static void main(String[] args) throws IOException {
        ReadCSV readCSV = new ReadCSV();
        readCSV.printAllLines();
        System.out.println("--- Now without Header ---");
        readCSV.printLinesWithoutHeader();
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




}
