package com.codesprint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codesprint.Service.QuestionService;
import com.codesprint.Service.ProgressService;
import com.codesprint.entity.Student;
import jakarta.servlet.http.HttpSession;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ProgressService progressService;

    @GetMapping("/questions/{subjectId}")
    public String questions(@PathVariable Long subjectId, HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) return "redirect:/login";

        var questions = questionService.getQuestionsBySubject(subjectId);
        // attach status for each question
        var statusMap = new java.util.HashMap<Long, String>();
        for (var q : questions) {
            statusMap.put(q.getId(), progressService.getStatus(student.getId(), q.getId()));
        }
        model.addAttribute("questions", questions);
        model.addAttribute("statusMap", statusMap);
        model.addAttribute("subjectId", subjectId);
        return "questions";
    }

    @PostMapping("/questions/mark")
    public String markStatus(@RequestParam Long questionId,
                             @RequestParam Long subjectId,
                             @RequestParam String status,
                             HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) return "redirect:/login";
        progressService.markStatus(student.getId(), questionId, status, student);
        return "redirect:/questions/" + subjectId;
    }
}
