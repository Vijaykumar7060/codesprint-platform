package com.codesprint.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codesprint.entity.Progress;
import com.codesprint.entity.Question;
import com.codesprint.entity.Student;
import com.codesprint.repository.ProgressRepository;
import com.codesprint.repository.QuestionRepository;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void markStatus(Long studentId, Long questionId, String status, Student student) {
        Optional<Progress> existing = progressRepository.findByStudentIdAndQuestionId(studentId, questionId);
        Progress progress = existing.orElseGet(Progress::new);
        Question question = questionRepository.findById(questionId).orElse(null);
        progress.setStudent(student);
        progress.setQuestion(question);
        progress.setStatus(status);
        progressRepository.save(progress);
    }

    public long countCompleted(Long studentId) {
        return progressRepository.countByStudentIdAndStatus(studentId, "completed");
    }

    public long countPending(Long studentId) {
        return progressRepository.countByStudentIdAndStatus(studentId, "pending");
    }

    public String getStatus(Long studentId, Long questionId) {
        return progressRepository.findByStudentIdAndQuestionId(studentId, questionId)
                .map(Progress::getStatus).orElse(null);
    }
}
