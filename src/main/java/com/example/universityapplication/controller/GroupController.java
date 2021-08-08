package com.example.universityapplication.controller;


import com.example.universityapplication.dto.response.GroupByIdResponseDTO;
import com.example.universityapplication.dto.response.GroupResponseDTO;
import com.example.universityapplication.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/university")
public class GroupController {

    @Autowired
    @Qualifier("groupServiceImpl")
    private GroupService groupService;

    @PostMapping(path = "/groups")
    public void add(@RequestBody GroupByIdResponseDTO groupByIdResponseDTO) {
        groupService.add(groupByIdResponseDTO);
    }

    @GetMapping(path = "/groups/{id}")
    public GroupByIdResponseDTO getGroupById(@PathVariable(name = "id") Long id) {
        return groupService.getGroupById(id);
    }

    @GetMapping(path = "/groups")
    public List<GroupResponseDTO> getAllGroups() {
        return groupService.getAllGroups();
    }
}
