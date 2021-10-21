package ru.digitallegua.examtask.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitallegua.examtask.model.TeacherModel;
import ru.digitallegua.examtask.service.TeacherServiceImpl;

@RestController
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @ApiOperation(value = "Добавить учителя")
    @PostMapping("/api/addTeacher")
    public void saveTeacher(@RequestBody TeacherModel teacherModel){
        teacherServiceImpl.addToListener(teacherModel);
    }

    @ApiOperation(value = "Удалить преподавателя")
    @PostMapping("/api/deleteTeacherById")
    public void deleteTeacher(@RequestBody TeacherModel teacherModel){
        teacherServiceImpl.deleteTeacherById(teacherModel);
    }

    @ApiOperation(value = "Обновить данные преподавателя")
    @PostMapping("/api/updateTeacher")
    public void updateTeacher(@RequestBody TeacherModel teacherModel){
        teacherServiceImpl.updateTeacher(teacherModel);
    }

    @ApiOperation(value = "Получить всех студентов")
    @GetMapping("/api/getAllTeachers")
    public void getAllTeachers(){
        teacherServiceImpl.findAllTeachers();
    }
}
