package com.unibook.demostudent.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDto {

    private String name;

    private String email;

}
