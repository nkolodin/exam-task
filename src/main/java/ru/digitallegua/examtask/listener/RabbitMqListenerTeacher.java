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
import ru.digitallegua.examtask.model.TeacherModel;
import ru.digitallegua.examtask.service.TeacherServiceImpl;

import java.io.IOException;

@Component
@EnableRabbit
@Slf4j
@ConditionalOnBean(value = RabbitTemplate.class)
public class RabbitMqListenerTeacher {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private  TeacherServiceImpl teacherService;

    public RabbitMqListenerTeacher(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Получаем информацию о заказе.
     */
    @RabbitListener(queues = "student")
    public void processRabbitMessage(Message message) throws IOException {
        byte[] bytes = message.getBody();
        TeacherModel teacherModel = objectMapper.readValue(bytes, TeacherModel.class);
        log.info("Received message from rabbitmq " + teacherModel.toString());
        teacherService.saveTeacher(teacherModel);
    }

}
