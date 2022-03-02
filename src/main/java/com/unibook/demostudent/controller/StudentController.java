package com.unibook.demostudent.controller;

import com.unibook.demostudent.model.dto.StudentResponseDto;
import com.unibook.demostudent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public StudentResponseDto getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
}
