package com.codesprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codesprint.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
