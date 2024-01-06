package Bai11.SpringMVC.rest;

import Bai11.SpringMVC.entity.Student;
import Bai11.SpringMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student/students";
    }
}
