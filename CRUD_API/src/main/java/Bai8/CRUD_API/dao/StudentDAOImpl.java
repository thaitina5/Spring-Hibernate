package Bai8.CRUD_API.dao;

import Bai8.CRUD_API.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAll() {
        String jpql = "SELECT s FROM Student s"; //select Entity ko phai Table
        return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student st) {
        entityManager.persist(st);
        return st;
    }

    @Override
    public Student saveAndFlush(Student st) {
        entityManager.merge(st);
        entityManager.flush(); //đẩy thay đổi xuống để hiện ra, vì merge vẫn còn nằm ở bộ nhớ
        return st;
    }

    @Override
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
