package com.example.universityapplication.service;

import com.example.universityapplication.dto.response.GroupByIdResponseDTO;
import com.example.universityapplication.dto.response.GroupResponseDTO;

import java.util.List;

public interface GroupService {
    void add(GroupByIdResponseDTO groupByIdResponseDTO);

    GroupByIdResponseDTO getGroupById(Long id);

    List<GroupResponseDTO> getAllGroups();
}
