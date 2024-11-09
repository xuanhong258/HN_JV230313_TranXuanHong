package ra.crud.repository;

import ra.crud.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean create(Student student);
    boolean update(Student student);
    boolean delete(int id);
    List<Student> findByName(String name);
}
