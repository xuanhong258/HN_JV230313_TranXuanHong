package ra.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.crud.dto.request.StudentDTO;
import ra.crud.model.Student;
import ra.crud.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "student";
    }

    @GetMapping("/initCreate")
    public String initCreate(Model model){
        model.addAttribute("newStudentDTO", new StudentDTO());
        return "createStudent";
    }

    @PostMapping("/create")
    public String create(StudentDTO studentDTO){
        boolean result = studentService.create(studentDTO);
        if(result){
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdate(@RequestParam("id") int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("studentUpdateDTO", StudentDTO.builder()
                .studentId(id)
                .studentName(student.getStudentName())
                .address(student.getAddress())
                .sex(student.isSex())
                .birthday(student.getBirthday())
                .phoneNumber(student.getPhoneNumber()).build());
        return "studentUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("studentUpdateDTO") StudentDTO studentUpdate){
       boolean result = studentService.update(studentUpdate);
        if(result){
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        boolean result = studentService.delete(id);
        if(result){
            return "redirect:findAll";
        }
        return "error";
    }
}
