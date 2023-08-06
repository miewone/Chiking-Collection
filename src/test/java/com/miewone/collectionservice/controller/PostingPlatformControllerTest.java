package com.miewone.collectionservice.controller;

/**
 * Created by wgPark on 2023-08-06.
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostingPlatformControllerTest {

    private MockMvc mockMvc;

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("포스팅 조회 성공 테스트")
    void findByIdSuccessTest() throws Exception {
        Long id = 1L;

        ResultActions result = mockMvc.perform(
                get("/platform/" + id)
                        .accept(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(PostingPlatformController.class))
                .andExpect(handler().methodName("findById"))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.seq", is(1)))
                .andExpect(jsonPath("$.response.name", is("Test Name 1")))
                .andExpect(jsonPath("$.response.description", is("Test Description 1")))
                .andExpect(jsonPath("$.response.url", is("http://testurl1.com")))
                .andExpect(jsonPath("$.response.schedule", is("*/5 * * * *")))
                .andExpect(jsonPath("$.response.createAt").exists())
        ;
    }

    @Test
    @DisplayName("포스팅 조회 실패 테스트 (존재하지 않는 ID)")
    void findByIdFailureTest() throws Exception {
        Long id = 100L;

        ResultActions result = mockMvc.perform(
                get("/platform/" + id)
                        .accept(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(PostingPlatformController.class))
                .andExpect(handler().methodName("findById"))
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.error").exists())
                .andExpect(jsonPath("$.error.status", is(404)))
        ;
    }
    @Test
    @DisplayName("포스팅 리스트 성공 조회 테스트")
    void findByAllSuccessTest() throws Exception {

        ResultActions result = mockMvc.perform(
                get("/platform/all")
                        .accept(MediaType.APPLICATION_JSON)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(PostingPlatformController.class))
                .andExpect(handler().methodName("findAll"))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response", hasSize(10)))
                .andExpect(jsonPath("$.response[0].name", is("Test Name 1")))
        ;
    }
}
