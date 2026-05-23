package com.codesprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesprint.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByEmail(String email);

}
