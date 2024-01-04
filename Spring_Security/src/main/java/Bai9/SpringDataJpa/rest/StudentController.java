package Bai9.SpringDataJpa.rest;

import Bai9.SpringDataJpa.entity.Student;
import Bai9.SpringDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return this.studentService.getAllStudent();
    }

    @GetMapping("/not-first-name/{name}")
    public List<Student> getAllStudentNotFirstName(@PathVariable String name){
        return this.studentService.getAllStudentNotFirstName(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
         Student student = studentService.getStudentById(id);
         if(student != null){
             return ResponseEntity.ok(student);
         }else{
             return ResponseEntity.notFound().build();
         }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student st){
        st.setId(0);
        st = studentService.addStudent(st);
        return ResponseEntity.status(HttpStatus.CREATED).body(st);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student st){
        Student existStudent = studentService.getStudentById(id);
        if(existStudent!=null){
            existStudent.setFirstName(st.getFirstName());
            existStudent.setLastName(st.getLastName());
            existStudent.setEmail(st.getEmail());
            studentService.updateStudent(existStudent);
            return ResponseEntity.ok(existStudent);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        Student existStudent = studentService.getStudentById(id);
        if(existStudent!=null){
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
