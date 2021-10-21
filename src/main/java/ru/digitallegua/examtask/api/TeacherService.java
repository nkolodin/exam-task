package ru.digitallegua.examtask.api;

import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.model.TeacherModel;

import java.util.List;

public interface TeacherService {
    List<TeacherModel> findAllTeachers();
    TeacherModel getTeacherById(TeacherModel teacherModel);
    void deleteTeacherById(TeacherModel teacherModel);
    void saveTeacher(TeacherModel teacherModel);
    void updateTeacher(TeacherModel teacherModel);
}
