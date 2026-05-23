package com.codesprint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codesprint.Service.StudentService;
import com.codesprint.entity.Student;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/signup")
    public String signupPage(Model model) {

        model.addAttribute("student", new Student());

        return "signup";
    }

    @PostMapping("/register")
    public String registerStudent(
            @ModelAttribute Student student) {

        studentService.registerStudent(student);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @PostMapping("/loginCheck")
    public String loginCheck(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        Student student =
                studentService.getStudentByEmail(email);

        if(student != null &&
           student.getPassword().equals(password)) {

            session.setAttribute("student", student);

            return "redirect:/dashboard";
        }

        model.addAttribute("error",
                "Invalid Email or Password");

        return "login";
    }
}


