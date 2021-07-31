package com.example.universityapplication.controller;

import com.example.universityapplication.dto.GroupDTO;
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
    public void add(@RequestBody GroupDTO groupDTO) {
    groupService.add(groupDTO);
}

@GetMapping(path= "/groups/{id}")
    public GroupDTO getGroupById(@PathVariable(name = "id") Long id) {
    return groupService.getGroupById(id);
}

@GetMapping(path= "/groups")
    public List<GroupDTO> getAllGroups() {
    return groupService.getAllGroups();
    }
}
