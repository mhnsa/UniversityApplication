package com.example.universityapplication.service;

import com.example.universityapplication.dto.request.StudentRequestDTO;
import com.example.universityapplication.model.Group;
import com.example.universityapplication.model.Student;
import com.example.universityapplication.repository.GroupRepository;
import com.example.universityapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void addStudentToGroup(StudentRequestDTO studentRequestDTO) {

        Group group = groupRepository.findById(studentRequestDTO.getGroupId()).get();

        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setSurname(studentRequestDTO.getSurName());
        student.setCreateAt(LocalDate.now());
        student.setGroup(group);

        studentRepository.save(student);
    }

}
