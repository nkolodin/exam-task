package ru.digitallegua.examtask.api;

import ru.digitallegua.examtask.model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> findAllStudents();
    StudentModel getStudentById(Long id);
    void deleteStudentById(StudentModel studentModel);
    void saveStudent(StudentModel model);
    void updateStudent(StudentModel student);
}
