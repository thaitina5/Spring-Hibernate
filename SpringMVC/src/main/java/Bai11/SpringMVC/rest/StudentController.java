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

    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        // attribute name phải trùng vs attribute object bên vỉew
        // thì View và Controller ms tương tác vs nhau dc
        model.addAttribute("student", student);
        return "student/students-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/students-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }
}
