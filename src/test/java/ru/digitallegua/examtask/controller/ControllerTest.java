package ru.digitallegua.examtask.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.digitallegua.examtask.model.StudentModel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ControllerTest {

    private final MockMvc mvc;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @SneakyThrows
    private String toJson(Object o) {
        return mapper.writeValueAsString(o);
    }

    @Test
    @Order(1)
    @SneakyThrows
    void shouldAcceptNewSocksIncome() throws Exception {
        mvc.perform(post("/api/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(new StudentModel(1L)))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    void shouldReturnBadRequestWhenBadSockGiven() {
        mvc.perform(post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(new StudentModel(1L, "Nikita", "Nikita", "Nikita")))
                .characterEncoding("UTF-8"))
                .andExpect(status().is4xxClientError());
    }
}
