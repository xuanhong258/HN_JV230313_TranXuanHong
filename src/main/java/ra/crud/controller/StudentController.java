package ra.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.crud.dto.request.StudentDTO;
import ra.crud.model.Student;
import ra.crud.service.StudentService;

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
    public String initCreate(StudentDTO studentDTO, BindingResult bindingResult){
        boolean result = studentService.create(studentDTO);
        if(bindingResult.hasErrors()){
            return "createStudent";
        }
        if(result){
            return "redirect:findAll";
        }
        return "error";
    }


}
