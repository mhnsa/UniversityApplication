package com.example.universityapplication.service;


import com.example.universityapplication.dto.response.GroupByIdResponseDTO;
import com.example.universityapplication.dto.response.GroupResponseDTO;
import com.example.universityapplication.dto.response.StudentResponseDTO;
import com.example.universityapplication.model.Group;
import com.example.universityapplication.model.Student;
import com.example.universityapplication.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;


    @Override
    public void add(GroupByIdResponseDTO groupByIdResponseDTO) {

       Group group = Group.builder()
                .name(groupByIdResponseDTO.getName())
                .createAt(LocalDate.now())
                .build();

        groupRepository.save(group);


    }

    @Override
    public GroupByIdResponseDTO getGroupById(Long id) {
        Optional<Group> groupById = groupRepository.findById(id);

        Group group = groupById.orElseThrow(() ->
                new IllegalArgumentException("Group with id "+ id + " didn't find"));

        return GroupByIdResponseDTO.builder()
                .id(group.getId())
                .name(group.getName())
                .students(group.getStudents().stream()
                        .map(this::getStudentResponseDTOFromStudent)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<GroupResponseDTO> getAllGroups() {

        List<Group> all = groupRepository.findAll();

         return all.stream()
                .map(this::getGroupResponseDTOFromGroupEntity)
                .collect(Collectors.toList());
    }

    private GroupResponseDTO getGroupResponseDTOFromGroupEntity(Group group) {
        return GroupResponseDTO.builder()
                .id(group.getId())
                .quantity(group.getStudents().size())
                .name(group.getName())
                .createAt(group.getCreateAt())
                .build();
    }

    private StudentResponseDTO getStudentResponseDTOFromStudent(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .createAt(student.getCreateAt())
                .build();
    }

}
