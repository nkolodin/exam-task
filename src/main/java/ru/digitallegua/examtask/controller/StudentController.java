package ru.digitallegua.examtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.service.StudentServiceImpl;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping("/api/addStudent")
    public void saveStudent(@RequestBody StudentModel studentModel){
        studentServiceImpl.addToListener(studentModel);
    }

    @PostMapping("/api/deleteStudentById")
    public void deleteStudent(@RequestBody StudentModel studentModel){
        studentServiceImpl.deleteStudentById(studentModel);
    }

    @PostMapping("/api/updateStudent")
    public void updateStudent(@RequestBody StudentModel studentModel){
        studentServiceImpl.updateStudent(studentModel);
    }

    @PostMapping("/api/updateStudent/{id}")
    public void getStudentById(@PathVariable(name = "id") Long id){
        studentServiceImpl.getStudentById(id);
    }

    @GetMapping("/api/getAllStudents")
    public void getAllStudents(){
        studentServiceImpl.findAllStudents();
    }

}
