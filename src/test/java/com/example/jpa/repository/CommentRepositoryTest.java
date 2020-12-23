package com.example.jpa.repository;

import com.example.jpa.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        Comment comment = new Comment();
        comment.setComment("hello Comment 한글은?");
        commentRepository.save(comment);

        List<Comment> comments = commentRepository.findAll();
        assertThat(comments.size()).isEqualTo(1);

        Optional<Comment> byId = commentRepository.findById(100l);
        assertThat(byId).isEmpty();
        // Optional 이용한 예외처리 구현 코드
//        Comment byIdComment = byId.orElseThrow(IllegalAccessError::new);
    }
}