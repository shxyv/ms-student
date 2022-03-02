package com.unibook.demostudent.dao.repository;

import com.unibook.demostudent.dao.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
