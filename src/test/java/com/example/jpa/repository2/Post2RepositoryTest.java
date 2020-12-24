package com.example.jpa.repository2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Post2RepositoryTest {

    @Autowired
    Post2Repository post2Repository;

    @Test
    public void crud() {
//        post2Repository.findMyPost();

        Post2 post2 = new Post2();
        post2.setTitle("hibernate");

        // Transient 상태
        assertThat(post2Repository.contains(post2)).isFalse();

        post2Repository.save(post2);

        // Persistent 상태
        assertThat(post2Repository.contains(post2)).isTrue();
        post2Repository.delete(post2);
        // 롤백 되기 때문에 삭제 강제로 실행시키기 위해 flush()
        post2Repository.flush();
    }
}