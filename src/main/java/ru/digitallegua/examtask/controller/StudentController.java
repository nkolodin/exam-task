package ru.digitallegua.examtask.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.service.StudentServiceImpl;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @ApiOperation(value = "Добавить студента")
    @PostMapping("/api/addStudent")
    public void saveStudent(@RequestBody StudentModel studentModel){
        studentServiceImpl.addToListener(studentModel);
    }

    @ApiOperation(value = "Удалить студента по id")
    @PostMapping("/api/deleteStudentById")
    public void deleteStudent(@RequestBody StudentModel studentModel){
        studentServiceImpl.deleteStudentById(studentModel);
    }

    @ApiOperation(value = "Обновить параметры студента")
    @PostMapping("/api/updateStudent")
    public void updateStudent(@RequestBody StudentModel studentModel){
        studentServiceImpl.updateStudent(studentModel);
    }

    @ApiOperation(value = "Обновить студента по id")
    @PostMapping("/api/updateStudent/{id}")
    public void getStudentById(@PathVariable(name = "id") Long id){
        studentServiceImpl.getStudentById(id);
    }

    @ApiOperation(value = "Получить всех студентов")
    @GetMapping("/api/getAllStudents")
    public void getAllStudents(){
        studentServiceImpl.findAllStudents();
    }




}
