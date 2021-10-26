package com.javainuse.controllers;

import com.javainuse.exception.ResourceNotFoundException;
import com.javainuse.model.Student;
import com.javainuse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public Student createStudents(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + studentId));
        return ResponseEntity.ok().body(student);
    }
}
