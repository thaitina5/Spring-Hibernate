package Bai8.CRUD_API.service;

import Bai8.CRUD_API.dao.StudentDAO;
import Bai8.CRUD_API.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudent(){
        return this.studentDAO.getAll();
    }

    @Override
    public Student getStudentById(int id) {
        return this.studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student st) {
        return this.studentDAO.save(st);
    }

    @Override
    @Transactional
    public Student updateStudent(Student st) {
        return this.studentDAO.saveAndFlush(st);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        this.studentDAO.delete(id);
    }
}
