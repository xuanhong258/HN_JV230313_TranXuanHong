package ra.crud.service;

import ra.crud.dto.request.StudentDTO;
import ra.crud.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean create(StudentDTO studentDTO);
    boolean update(StudentDTO studentDTO);
    boolean delete(int id);
    List<Student> findByName(String name);
}
