package Bai8.SpringDataJpa.dao;

import Bai8.SpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
