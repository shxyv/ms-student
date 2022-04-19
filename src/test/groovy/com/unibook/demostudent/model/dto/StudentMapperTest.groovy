package com.unibook.demostudent.model.dto

import com.unibook.demostudent.dao.entity.StudentEntity
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class StudentMapperTest extends Specification {

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def "EntityToDto test"() {
        given:
        def studentEntity = random.nextObject(StudentEntity)
        when:
        def result = StudentMapper.entityToDto(studentEntity)
        then:
        result.getName() == studentEntity.getName()
        result.getEmail() == studentEntity.getEmail()
    }

    def "ListEntityToListDto test"() {
        given:
        def studentEntityList = random.nextObject(List<StudentEntity>)
        when:
        def result = StudentMapper.listEntityToListDto(studentEntityList)
        then:
        for (int i = 0; i < result.size(); i++) {
            result.get(i).getName() == studentEntityList.get(i).getName()
            result.get(i).getEmail() == studentEntityList.get(i).getEmail()
        }

    }

    def "DtoToEntity test "() {
        given:
        def studentDto = random.nextObject(StudentRequestDto)
        when:
        def result = StudentMapper.dtoToEntity(studentDto)
        then:
        result.getName() == studentDto.getName()
        result.getEmail() == studentDto.getEmail()
    }
}
