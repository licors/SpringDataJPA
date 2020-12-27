package com.example.jpa.webPost;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// test 에 쓰이는 프로파일 따로 오버라이딩해서 쓰고 싶으면 아래 애노테이션 사용
// @ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Post3ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Post3Repository post3Repository;

    @Test
    public void getPost() throws Exception {
        Post3 post3 = new Post3();
        post3.setTitle("jpa");
        post3Repository.save(post3);

        mockMvc.perform(get("/posts/" + post3.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("jpa"));
    }

    @Test
    public void getPosts() throws Exception {
        Post3 post3 = new Post3();
        post3.setTitle("jpa");
        post3Repository.save(post3);

        mockMvc.perform(get("/posts/")
                    .param("page", "0")
                    .param("size", "10")
                    .param("sort", "created,desc")
                    .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result->{
                    jsonPath("$.content[0].title", is("jpa"));
                });
    }
}