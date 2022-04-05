package de.neuefische.cgn221springstudent.repo;

import de.neuefische.cgn221springstudent.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class StudentRepo {
    Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId() ,student);
    }
    public Student getStudentById (String id){
       return students.get(id);
    }

    public List<Student> getAllStudentsAsList() {
        List<Student> studentsArrayList = new ArrayList<Student>();
        for (String key  : students.keySet())  {
            studentsArrayList.add(students.get(key));
        }
        return studentsArrayList;
    }

    public void delStudentById (String id) {
        students.remove(id);
    }

    public List<Student> getStudentsByPartOfName(String partOfName) {
        List<Student> studentsArrayList = new ArrayList<Student>();
        for (String key  : students.keySet())  {
            if(students.get(key).getName().toUpperCase().contains((partOfName).toUpperCase())) {
                studentsArrayList.add(students.get(key));
            }
        }
        return studentsArrayList;
    }
}
