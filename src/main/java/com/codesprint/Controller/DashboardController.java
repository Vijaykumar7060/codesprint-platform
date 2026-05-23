package com.codesprint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codesprint.Service.ProgressService;
import com.codesprint.Service.SubjectService;
import com.codesprint.entity.Student;
import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ProgressService progressService;

    @GetMapping({"/", "/dashboard"})
    public String dashboard(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) return "redirect:/login";

        model.addAttribute("totalSubjects", subjectService.getAllSubjects().size());
        model.addAttribute("completed", progressService.countCompleted(student.getId()));
        model.addAttribute("pending", progressService.countPending(student.getId()));
        model.addAttribute("student", student);
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
