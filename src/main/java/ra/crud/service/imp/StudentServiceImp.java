package ra.crud.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.crud.dto.request.StudentDTO;
import ra.crud.model.Student;
import ra.crud.repository.StudentRepository;
import ra.crud.service.StudentService;
import ra.crud.service.UploadFileService;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean create(StudentDTO studentDTO) {
        String imageUrl = uploadFileService.uploadFileToLocal(studentDTO.getImageUrl());
        Student student = new Student().builder()
                .studentName(studentDTO.getStudentName())
                .phoneNumber(studentDTO.getPhoneNumber())
                .imageUrl(imageUrl)
                .sex(studentDTO.isSex())
                .address(studentDTO.getAddress())
                .birthday(studentDTO.getBirthday())
                .build();
        return studentRepository.create(student);
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        String imageUrl = uploadFileService.uploadFileToLocal(studentDTO.getImageUrl());
        Student student = new Student().builder()
                .studentName(studentDTO.getStudentName())
                .phoneNumber(studentDTO.getPhoneNumber())
                .imageUrl(imageUrl)
                .sex(studentDTO.isSex())
                .address(studentDTO.getAddress())
                .birthday(studentDTO.getBirthday())
                .build();
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
