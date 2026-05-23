package com.codesprint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codesprint.Service.SubjectService;
import com.codesprint.entity.Student;
import jakarta.servlet.http.HttpSession;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public String subjects(HttpSession session, Model model) {
        if (session.getAttribute("student") == null) return "redirect:/login";
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subjects";
    }
}
