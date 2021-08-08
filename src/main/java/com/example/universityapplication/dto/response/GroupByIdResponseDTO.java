package com.example.universityapplication.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupByIdResponseDTO {

    private Long id;
    private String name;
    private List<StudentResponseDTO> students;

}
