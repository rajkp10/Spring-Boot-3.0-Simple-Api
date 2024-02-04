package com.practiceproject1.simpleapi.student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{firstName}")
    public ResponseEntity<?> getStudentByFirstName(@PathVariable("firstName") String firstName){
        return new ResponseEntity<>(studentService.findByFirstName(firstName), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

//    @GetMapping("/student/laptop/{laptopId}")
//    public ResponseEntity<?> getStudentByLaptop(@PathVariable("laptopId") UUID laptopId){
//        return new ResponseEntity<>(studentService.getStudentByLaptop(laptopId), HttpStatus.OK);
//    }
}
