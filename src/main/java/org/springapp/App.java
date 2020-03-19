package org.springapp;

import org.springapp.client.StudentClient;
import org.springapp.config.AppConfig;
import org.springapp.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;

public class App
{
    private static StudentClient client;
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        client = (StudentClient) context.getBean("studentClientImpl");

        getAll();

        getById();

        delete();

        update();

        addStudent();

    }

    private static void update() {
        client.updateStudent(new Student(5,"RN3","manisha","davv"));
    }

    private static void delete() {
        client.deleteStudent(4);
    }

    private static void getAll() {
        for (Student student:client.getAllStudents())
        {
        System.out.println(student);
        }
    }

    private static void getById(){
        Student student = client.getById(1);
        System.out.println(student);
    }

    private static void addStudent(){
        Student student = new Student();
        student.setRollNo("RN3");
        student.setName("poorvi");
        student.setUniversity("manit");
        System.out.println(client.addStudent(student));
    }

}
