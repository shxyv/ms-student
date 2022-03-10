package com.unibook.demostudent.service;

import com.unibook.demostudent.dao.entity.StudentEntity;
import com.unibook.demostudent.dao.repository.StudentRepository;
import com.unibook.demostudent.model.dto.StudentRequestDto;
import com.unibook.demostudent.model.dto.StudentResponseDto;
import com.unibook.demostudent.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unibook.demostudent.model.dto.StudentMapper.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDto getStudent(Long id) {
        StudentEntity student = findStudentIfExists(id);
        return entityToDto(student);
    }

    public List<StudentResponseDto> getStudents() {
        List<StudentEntity> students = (List<StudentEntity>) studentRepository.findAll();
        return listEntityToListDto(students);
    }

    public void createStudent(StudentRequestDto studentRequestDto) {
        studentRepository.save(dtoToEntity(studentRequestDto));
    }

    public void updateStudent(Long id, StudentRequestDto studentRequestDto) {
        StudentEntity student = findStudentIfExists(id);
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        StudentEntity student = findStudentIfExists(id);
        studentRepository.delete(student);
    }

    private StudentEntity findStudentIfExists(Long id) {
        return studentRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Student not found!"));
    }

}
