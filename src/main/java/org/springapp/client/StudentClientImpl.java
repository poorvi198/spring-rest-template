package org.springapp.client;

import org.springapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
@Qualifier
public class StudentClientImpl implements StudentClient {

    @Autowired
    RestTemplate restTemplate;
    private final String url="http://localhost:8090/spring-rest-jdbc/students";
    @Override
    public List<Student> getAllStudents() {
        ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(url,Student[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    @Override
    public Student getById(int id) {
        ResponseEntity<Student> responseEntity = restTemplate.getForEntity(url+"/"+id,Student.class);
        return responseEntity.getBody();
    }

    @Override
    public Student addStudent(Student student) {
        ResponseEntity<Student> studentResponseEntity = restTemplate.postForEntity(url,student,Student.class);
        return studentResponseEntity.getBody();
    }

    @Override
    public void updateStudent(Student student) {
        restTemplate.put(url,student);
    }

    @Override
    public void deleteStudent(int id) {
        restTemplate.delete(url+"/"+id);
    }
}
