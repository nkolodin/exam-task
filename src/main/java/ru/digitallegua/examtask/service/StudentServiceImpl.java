package ru.digitallegua.examtask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitallegua.examtask.api.StudentService;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void deleteStudentById(StudentModel student) {
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void saveStudent(StudentModel model) {
        studentRepository.save(model);
    }

    @Override
    public void updateStudent(StudentModel student) {
        StudentModel studentFromBase = studentRepository.getById(student.getId());
        studentFromBase.setName(student.getName());
        studentFromBase.setLastName(student.getLastName());
        studentFromBase.setMiddleName(student.getMiddleName());
        studentFromBase.setCourse(student.getCourse());
        studentFromBase.setSpeciality(student.getSpeciality());
    }

    public void addToListener(StudentModel studentModel) {
        String message = null;
        try {
            message = objectMapper.writeValueAsString(studentModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        amqpTemplate.convertAndSend("student", message);
    }


}
