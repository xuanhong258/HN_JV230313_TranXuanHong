package ra.crud.repository.imp;

import org.springframework.stereotype.Repository;
import ra.crud.model.Student;
import ra.crud.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentRepositoryImp implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student ", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.createQuery("from Student s where s.id= :id", Student.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Student student) {
        try {
            entityManager.persist(student);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Student student) {
        try {
            entityManager.merge(student);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Student student = entityManager.find(Student.class, id);
        try {
            entityManager.remove(student);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findByName(String name) {
        try {
            return entityManager.createQuery("from Student s where s.studentName like :name", Student.class)
                    .setParameter("name","%" + name + "%").getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
