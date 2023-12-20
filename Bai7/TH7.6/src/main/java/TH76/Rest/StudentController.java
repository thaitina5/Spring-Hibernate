package TH76.Rest;

import TH76.Entity.ErrorResponse;
import TH76.Entity.Student;
import TH76.Exception.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    //bai7.7 chuyển đổi từ POJO sang JSON
    public List<Student> list = new ArrayList<Student>();

    @PostConstruct
    public void createList(){
        list.add(new Student(1, "abc", 18, "math", 9));
        list.add(new Student(2, "abb", 18, "math", 6));
        list.add(new Student(3, "ab3", 18, "math", 12));
        list.add(new Student(4, "ab4", 18, "math", 8));
        list.add(new Student(5, "abt", 18, "math", 34));
    }

    @GetMapping("/")
    public List<Student> getList(){
        return list;
    }

    //bai7.8 Path Variable
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        Student result = null;
        for(Student st: list){
            if(st.getId() == id){
                return st;
            }
        }
        if(result == null){
            throw new StudentException("Can't find student with "+id+" id");
        }
        return result;
    }

    @GetMapping("/index/{index}")
    public Student getStudentIndex(@PathVariable int index){
        Student result = null;
        try {
            result = list.get(index);
        }catch(IndexOutOfBoundsException e){
            throw new StudentException("Can't find student with index: "+index);
        }
        return result;
    }
    //ngoài ra còn có thể thêm nhìu biến path variable
    //vd: @GetMapping("/index/{index}/{v}/{t}")
    //    (@PathVariable int index, @PathVariable int v,....)

    //B7.9
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchError(StudentException stex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), stex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchAllError(Exception stex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), stex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }
}
