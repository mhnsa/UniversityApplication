package com.example.universityapplication.service;

import com.example.universityapplication.dto.GroupDTO;
import com.example.universityapplication.model.Group;
import com.example.universityapplication.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;


    @Override
    public void add(GroupDTO groupDTO) {

       Group group = Group.builder()
                .name(groupDTO.getName())
                .createAt(LocalDate.now())
                .build();

        groupRepository.save(group);


    }

    @Override
    public GroupDTO getGroupById(Long id) {
        Optional<Group> groupById = groupRepository.findById(id);

        Group group = groupById.get();
        GroupDTO groupDTO = GroupDTO.builder()
                .name(group.getName())
                .build();

        return groupDTO;
    }

    @Override
    public List<GroupDTO> getAllGroups() {

        List<Group> all = groupRepository.findAll();
        List<GroupDTO> groupDTOS = new ArrayList<>();

        for (Group group: all) {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setName(group.getName());
            groupDTOS.add(groupDTO);
        }
        return groupDTOS;
    }
}
