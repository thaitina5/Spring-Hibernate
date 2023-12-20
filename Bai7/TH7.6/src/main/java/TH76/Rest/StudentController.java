package TH76.Rest;

import TH76.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        for(Student st: list){
            if(st.getId() == id){
                return st;
            }
        }
        return null;
    }

    @GetMapping("/index/{index}")
    public Student getStudentIndex(@PathVariable int index){
        Student student = list.get(index);
        return student;
    }
    //ngoài ra còn có thể thêm nhìu biến path variable
    //vd: @GetMapping("/index/{index}/{v}/{t}")
    //    (@PathVariable int index, @PathVariable int v,....)
}
