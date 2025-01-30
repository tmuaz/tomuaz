package com.muaz.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
class SpringdemoApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() throws Exception {
        final var req = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON);
        final var predicate = content().string(equalTo("Hi Muaz!\n"));
        mvc.perform(req).andExpect(predicate);
    }

}
