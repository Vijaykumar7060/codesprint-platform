package com.codesprint.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codesprint.entity.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByStudentId(Long studentId);
    Optional<Progress> findByStudentIdAndQuestionId(Long studentId, Long questionId);
    long countByStudentIdAndStatus(Long studentId, String status);
}
