package org.springapp.client;

import org.springapp.entity.Student;

import java.util.List;

public interface StudentClient{

    List<Student> getAllStudents();

    Student getById(int id);

    Student addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

}
