package com.daytona.demo.rest;

import com.daytona.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class StudentRestController {

    private static final Logger log = LoggerFactory.getLogger(StudentRestController.class);
    private List<Student> theStudents;

    //define @post construct to load the student data...only once
    @PostConstruct
    public void loadData(){
         theStudents=new ArrayList<>();
        theStudents.add(new Student("John","Doe"));
        theStudents.add(new Student("Aryan","kr"));
        theStudents.add(new Student("Aman","Singh"));

    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return theStudents;
    }

    //define endpoints or "/students/{studentId}" -return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //check the studentId again list size
        if( (studentId>=theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("StudentId not found - "+studentId);
        }
        return theStudents.get(studentId);
    }



}
