package ru.digitallegua.examtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.model.TeacherModel;
import ru.digitallegua.examtask.service.StudentServiceImpl;
import ru.digitallegua.examtask.service.TeacherServiceImpl;

@RestController
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @PostMapping("/api/addTeacher")
    public void saveStudent(@RequestBody TeacherModel teacherModel){
        teacherServiceImpl.saveTeacher(teacherModel);
    }

    @PostMapping("/api/deleteTeacherById")
    public void deleteStudent(@RequestBody TeacherModel teacherModel){
        teacherServiceImpl.deleteTeacherById(teacherModel);
    }

    @PostMapping("/api/updateStudent")
    public void updateStudent(@RequestBody TeacherModel teacherModel){
        teacherServiceImpl.updateTeacher(teacherModel);
    }

    @GetMapping("/api/getAllTeachers")
    public void getAllStudents(){
        teacherServiceImpl.findAllTeachers();
    }
}
