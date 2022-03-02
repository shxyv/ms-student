package com.unibook.demostudent.model.dto;

import com.unibook.demostudent.dao.entity.StudentEntity;

public class StudentMapper {

    public static StudentResponseDto entityToDto(StudentEntity studentEntity){
        return StudentResponseDto.builder()
                .name(studentEntity.getName())
                .email(studentEntity.getEmail())
                .build();
    }

}
