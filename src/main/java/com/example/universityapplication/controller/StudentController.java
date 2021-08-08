package com.example.universityapplication.controller;


import com.example.universityapplication.dto.request.StudentRequestDTO;
import com.example.universityapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/university")
public class StudentController {


@Autowired
    private StudentService studentService;

    @DeleteMapping(path = "/students/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping(path = "/students")
    public void addStudentToGroup(@RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.addStudentToGroup(studentRequestDTO);
    }



}
