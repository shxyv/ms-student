package com.unibook.demostudent.model.dto;

import com.unibook.demostudent.dao.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static StudentResponseDto entityToDto(StudentEntity studentEntity) {
        return StudentResponseDto.builder()
                .name(studentEntity.getName())
                .email(studentEntity.getEmail())
                .build();
    }

    public static List<StudentResponseDto> listEntityToListDto(List<StudentEntity> studentEntities) {
        List<StudentResponseDto> students = new ArrayList<>(studentEntities.size());
        for (StudentEntity studentEntity : studentEntities) {
            students.add(entityToDto(studentEntity));
        }
        return students;
    }

    public static StudentEntity dtoToEntity(StudentRequestDto studentRequestDto) {
        return StudentEntity.builder()
                .name(studentRequestDto.getName())
                .email(studentRequestDto.getEmail())
                .build();
    }

}
