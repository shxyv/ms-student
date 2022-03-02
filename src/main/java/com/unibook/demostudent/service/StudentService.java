package com.unibook.demostudent.service;

import com.unibook.demostudent.dao.entity.StudentEntity;
import com.unibook.demostudent.dao.repository.StudentRepository;
import com.unibook.demostudent.model.dto.StudentResponseDto;
import com.unibook.demostudent.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.unibook.demostudent.model.dto.StudentMapper.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDto getStudent(Long id){
       StudentEntity student = studentRepository.findById(id).orElseThrow(()
               -> new NotFoundException("Student not found!"));
       return entityToDto(student);
    }
}
