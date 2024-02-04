package com.practiceproject1.simpleapi.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllSubjects(){
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.createSubject(subject), HttpStatus.CREATED);
    }

    @PostMapping("/{subjectId}/student/{studentId}")
    public ResponseEntity<?> enrollStudent(@PathVariable("subjectId") UUID subjectId, @PathVariable("studentId") UUID studentId){
        return new ResponseEntity<>(subjectService.enrollStudent(subjectId, studentId), HttpStatus.OK);
    }

    @PutMapping("/{subjectId}/student/{studentId}")
    public ResponseEntity<?> enlistStudent(@PathVariable("subjectId") UUID subjectId, @PathVariable("studentId") UUID studentId){
        return new ResponseEntity<>(subjectService.enlistStudent(subjectId, studentId), HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable("subjectId")UUID subjectId){
        return new ResponseEntity<>(subjectService.deleteSubject(subjectId), HttpStatus.OK);
    }
}
