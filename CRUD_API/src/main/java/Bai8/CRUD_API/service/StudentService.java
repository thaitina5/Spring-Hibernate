package Bai8.CRUD_API.service;

import Bai8.CRUD_API.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student getStudentById(int id);
    public Student addStudent(Student st);
    public Student updateStudent(Student st);
    public void deleteStudentById(int id);

}
