package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/basseydou/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Ryan Gosling"),
            new Student(2,"Snoop Doggy Dogg"),
            new Student(11,"RKelly"),
            new Student(5,"Kelly Brooks")
    );



    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst().orElseThrow(()->new IllegalStateException("Student " + studentId + " doesn't exists"));

    }
    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return new ArrayList<>(STUDENTS);

    }

}
