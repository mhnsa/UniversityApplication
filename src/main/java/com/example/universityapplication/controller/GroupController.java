package com.example.universityapplication.controller;

import com.example.universityapplication.dto.GroupDTO;
import com.example.universityapplication.model.Group;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/university")
public class GroupController {



@PostMapping(path = "/groups")
    public void add(@RequestBody GroupDTO groupDTO) {

    System.out.println(groupDTO.getName());


}
}
