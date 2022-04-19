package com.unibook.demostudent.service

import com.unibook.demostudent.dao.entity.StudentEntity
import com.unibook.demostudent.dao.repository.StudentRepository
import com.unibook.demostudent.model.dto.StudentRequestDto
import com.unibook.demostudent.model.exception.NotFoundException
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

import static com.unibook.demostudent.model.dto.StudentMapper.*

class StudentServiceTest extends Specification {

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private StudentRepository studentRepository
    private StudentService studentService

    void setup(){
        studentRepository = Mock()
        studentService = new StudentService(studentRepository)
    }

    def "getStudent test when student is present"(){
        given:
        def id = 1L
        def mockEntity = random.nextObject(StudentEntity)
        when:
        def result = studentService.getStudent(id)
        then:
        1 * studentRepository.findById(id) >> Optional.of(mockEntity)
        result != null
    }

    def "getStudent test when student is not present"(){
        given:
        def id = 1L
        when:
        def result = studentService.getStudent(id)
        then:
        1 * studentRepository.findById(id) >> Optional.empty()
        NotFoundException ex = thrown()
        ex.getMessage() == "Student not found!"
    }

    def "getStudents test when students are present"(){
        given:
        def mockStudents = random.nextObject(List<StudentEntity>)
        when:
        def result = studentService.getStudents()
        then:
        1 * studentRepository.findAll() >> mockStudents
        mockStudents != null
    }

    def "getStudents test when students are not present"(){
        when:
        def result = studentService.getStudents()
        then:
        1 * studentRepository.findAll() >> []
        result != null
    }

    def "createStudent test"(){
        given:
        def studentDto = random.nextObject(StudentRequestDto)
        when:
        def result = studentService.createStudent(studentDto)
        then:
        1 * studentRepository.save(dtoToEntity(studentDto))
    }

    def "updateStudent test when student is present"(){
        given:
        def id = 1L
        def studentDto = random.nextObject(StudentRequestDto)
        def studentEntity = random.nextObject(StudentEntity)
        when:
        def result = studentService.updateStudent(id, studentDto)
        then:
        1 * studentRepository.findById(id) >> Optional.of(studentEntity)
        1 * studentRepository.save(studentEntity)
        studentEntity.getName() == studentDto.getName()
        studentEntity.getEmail() == studentDto.getEmail()
    }

    def "updateStudent test when student is not present"(){
        given:
        def id = 1L
        def studentDto = random.nextObject(StudentRequestDto)
        when:
        def result = studentService.updateStudent(id, studentDto)
        then:
        1 * studentRepository.findById(id) >> Optional.empty()
        NotFoundException ex = thrown()
        ex.getMessage() == "Student not found!"
    }

    def "deleteStudent test when student is present"(){
        given:
        def id = 1L
        def studentEntity = random.nextObject(StudentEntity)
        when:
        def result = studentService.deleteStudent(id)
        then:
        1 * studentRepository.findById(id) >> Optional.of(studentEntity)
        1 * studentRepository.delete(studentEntity)
    }

    def "deleteStudent test when student is not present"(){
        given:
        def id = 1L
        when:
        def result = studentService.deleteStudent(id)
        then:
        1 * studentRepository.findById(id) >> Optional.empty()
        NotFoundException ex = thrown()
        ex.getMessage() == "Student not found!"
    }
}
