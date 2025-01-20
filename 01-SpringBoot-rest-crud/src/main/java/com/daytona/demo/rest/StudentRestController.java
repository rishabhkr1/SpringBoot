package com.daytona.demo.rest;

import com.daytona.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @postconstruct to load the student data...only once
    @PostConstruct
    public void loadData(){
         theStudents=new ArrayList<>();
        theStudents.add(new Student("John","Snow"));
        theStudents.add(new Student("Arya","Stark"));
        theStudents.add(new Student("Jessy","Pinkman"));

    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return theStudents;
    }

    //define endpoints or "/students/{studentId}" -return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list
        return theStudents.get(studentId);
    }
}
