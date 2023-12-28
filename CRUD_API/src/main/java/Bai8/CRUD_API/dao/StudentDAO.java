package Bai8.CRUD_API.dao;

import Bai8.CRUD_API.entity.Student;

import java.util.List;


public interface StudentDAO {
    public List<Student> getAll();
    public Student getById(int id);
    public Student save(Student st);
    public Student saveAndFlush(Student st);
    public void delete(int id);
}
