package com.example.universityapplication.service;

import com.example.universityapplication.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    void add(GroupDTO groupDTO);

    GroupDTO getGroupById(Long id);

    List<GroupDTO> getAllGroups();
}
