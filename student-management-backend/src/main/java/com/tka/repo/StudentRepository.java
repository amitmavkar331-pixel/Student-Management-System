package com.tka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}


