package com.practiceproject1.simpleapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1")
@PreAuthorize("hasRole('ADMIN')")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/student")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping(path = "/student")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

//    @GetMapping("/student/laptop/{laptopId}")
//    public ResponseEntity<?> getStudentByLaptop(@PathVariable("laptopId") UUID laptopId){
//        return new ResponseEntity<>(studentService.getStudentByLaptop(laptopId), HttpStatus.OK);
//    }
}
