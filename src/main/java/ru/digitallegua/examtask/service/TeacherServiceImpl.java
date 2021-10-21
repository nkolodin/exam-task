package ru.digitallegua.examtask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitallegua.examtask.api.TeacherService;
import ru.digitallegua.examtask.exception.BadModelException;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.model.TeacherModel;
import ru.digitallegua.examtask.repository.StudentRepository;
import ru.digitallegua.examtask.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public TeacherServiceImpl( TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherModel> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherModel getTeacherById(TeacherModel teacherModel) {
        validate(teacherModel);
        return teacherRepository.getById(teacherModel.getId());
    }

    @Override
    public void deleteTeacherById(TeacherModel teacherModel) {
        validate(teacherModel);
        teacherRepository.deleteById(teacherModel.getId());
    }

    @Override
    public void saveTeacher(TeacherModel teacherModel) {
        teacherRepository.save(teacherModel);
    }

    @Override
    public void updateTeacher(TeacherModel teacherModel) {
        validate(teacherModel);
        TeacherModel teacherFromBase = teacherRepository.getById(teacherModel.getId());
        teacherFromBase.setName(teacherModel.getName());
        teacherFromBase.setLastName(teacherModel.getLastName());
        teacherFromBase.setMiddleName(teacherModel.getMiddleName());
        teacherFromBase.setDepartment(teacherModel.getDepartment());
    }

    public void addToListener(TeacherModel teacherModel) {
        validate(teacherModel);
        String message = null;
        try {
            message = objectMapper.writeValueAsString(teacherModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        amqpTemplate.convertAndSend("student", message);
    }

    private void validate(TeacherModel teacherModel) {
        if (teacherModel.getName() == null)  throw new BadModelException("invalid name");
        else if (teacherModel.getLastName() == null)  throw new BadModelException("invalid LastName");
        else if (teacherModel.getMiddleName() == null)  throw new BadModelException("invalid MiddleName");
    }
}
