package ru.digitallegua.examtask.service;

import org.springframework.stereotype.Service;
import ru.digitallegua.examtask.api.TeacherService;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.model.TeacherModel;
import ru.digitallegua.examtask.repository.StudentRepository;
import ru.digitallegua.examtask.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl( TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherModel> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherModel getTeacherById(TeacherModel teacherModel) {
        return teacherRepository.getById(teacherModel.getId());
    }

    @Override
    public void deleteTeacherById(TeacherModel teacherModel) {
        teacherRepository.deleteById(teacherModel.getId());
    }

    @Override
    public void saveTeacher(TeacherModel teacherModel) {
        teacherRepository.save(teacherModel);
    }

    @Override
    public void updateTeacher(TeacherModel teacherModel) {
        TeacherModel teacherFromBase = teacherRepository.getById(teacherModel.getId());
        teacherFromBase.setName(teacherModel.getName());
        teacherFromBase.setLastName(teacherModel.getLastName());
        teacherFromBase.setMiddleName(teacherModel.getMiddleName());
        teacherFromBase.setDepartment(teacherModel.getDepartment());
    }
}
