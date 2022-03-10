package com.unibook.demostudent.controller;

import com.unibook.demostudent.model.dto.StudentRequestDto;
import com.unibook.demostudent.model.dto.StudentResponseDto;
import com.unibook.demostudent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public StudentResponseDto getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.createStudent(studentRequestDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        studentService.updateStudent(id, studentRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }


}
