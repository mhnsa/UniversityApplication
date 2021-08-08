package com.example.universityapplication.service;

import com.example.universityapplication.dto.request.StudentRequestDTO;

public interface StudentService {
    void deleteById(Long id);

    void addStudentToGroup(StudentRequestDTO studentRequestDTO);
}
