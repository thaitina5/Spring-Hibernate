package Bai8.SpringDataJpa.service;

import Bai8.SpringDataJpa.dao.StudentRepository;
import Bai8.SpringDataJpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent(){
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return this.studentRepository.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student st) {
        return this.studentRepository.save(st);
    }

    @Override
    @Transactional
    public Student updateStudent(Student st) {
        return this.studentRepository.saveAndFlush(st);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
    }
}
