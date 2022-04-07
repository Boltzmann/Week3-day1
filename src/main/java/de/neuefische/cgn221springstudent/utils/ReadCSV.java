package de.neuefische.cgn221springstudent.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadCSV {
    public static void main(String[] args){
        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);
            Files.lines(Path.of(currentPath + "/students.csv"))
                    .forEach(student -> System.out.println(student));
        } catch (IOException e) {
            System.err.println("Path not OK.");
            e.printStackTrace();
        }
    }


}
