package com.example.universityapplication.repository;

import com.example.universityapplication.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {



}
