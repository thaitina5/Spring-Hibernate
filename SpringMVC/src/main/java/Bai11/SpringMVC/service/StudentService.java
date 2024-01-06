package Bai11.SpringMVC.service;

import Bai11.SpringMVC.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student getStudentById(int id);
    public Student addStudent(Student st);
    public Student updateStudent(Student st);
    public void deleteStudentById(int id);

}
