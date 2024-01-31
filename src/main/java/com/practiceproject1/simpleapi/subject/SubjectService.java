package com.practiceproject1.simpleapi.subject;

import com.practiceproject1.simpleapi.student.Student;
import com.practiceproject1.simpleapi.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public Subject enrollStudent(UUID subjectId, UUID studentId){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"no such subject"));
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"no such student"));
        student.getSubjects().add(subject);
        subject.getStudents().add(student);
        return subjectRepository.save(subject);
    }

    public Subject enlistStudent(UUID subjectId, UUID studentId){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"no such subject"));
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"no such student"));
        student.getSubjects().remove(subject);
        subject.getStudents().remove(student);
        return subjectRepository.save(subject);
    }

    public Subject deleteSubject(UUID subjectId){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"no such subject"));
        subjectRepository.delete(subject);
        return subject;
    }
}
