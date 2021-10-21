package ru.digitallegua.examtask.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import ru.digitallegua.examtask.model.StudentModel;
import ru.digitallegua.examtask.model.TeacherModel;
import ru.digitallegua.examtask.service.StudentServiceImpl;
import ru.digitallegua.examtask.service.TeacherServiceImpl;

import java.io.IOException;

@Component
@EnableRabbit
@Slf4j
@ConditionalOnBean(value = RabbitTemplate.class)
public class RabbitMqListenerStudent {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private  StudentServiceImpl studentService;


    /**
     * Получаем информацию о заказе.
     */
    @RabbitListener(queues = "teacher")
    public void processRabbitMessage(Message message) throws IOException {
        byte[] bytes = message.getBody();
        StudentModel studentModel = objectMapper.readValue(bytes, StudentModel.class);
        log.info("Received message from rabbitmq " + studentModel.toString());
        studentService.saveStudent(studentModel);
    }

}
