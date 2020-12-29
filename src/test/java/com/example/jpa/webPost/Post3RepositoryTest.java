package com.example.jpa.webPost;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Post3RepositoryTest {

    @Autowired
    private Post3Repository post3Repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void save() {
        Post3 post3 = new Post3();
        post3.setTitle("jpa");
        Post3 savedPost3 = post3Repository.save(post3);//  id가 없으므로 persist 에 넘겨줌

        assertThat(entityManager.contains(post3)).isTrue();  // post3 가 persist 상태
        assertThat(entityManager.contains(savedPost3)).isTrue();  //  savedPost3 가 persist 상태
        assertThat(post3 == savedPost3).isTrue();

        Post3 post3Update = new Post3();
        post3Update.setId(post3.getId());
        post3Update.setTitle("hibernate");
        // 항상 이런식으로 리턴값 받아서 쓰면 비교적 안전하다.
        Post3 updatedPost3 = post3Repository.save(post3Update);// merge 복사본을 만들고 이를 persist 상태로 만들고 리턴

        assertThat(entityManager.contains(post3Update)).isFalse();  // 그래서 기존 post3Update 는 persist 상태 아님
        assertThat(entityManager.contains(updatedPost3)).isTrue();  // db 에 영속화
        assertThat(post3Update == updatedPost3).isFalse();  // 두 개가 다른 것 확인

        updatedPost3.setTitle("change value");  // 이런식으로 리턴객체 사용해야 변화 감지함

        List<Post3> all = post3Repository.findAll();  // 이 함수 없이 위에 save 만 하면 jpa 최적화로 인해 insert, update 안날라감
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartsWith() {
        Post3 post3 = new Post3();
        post3.setTitle("spring Data Jpa");
        post3Repository.save(post3);

        List<Post3> all = post3Repository.findByTitleStartsWith("spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle() {
        Post3 post3 = new Post3();
        post3.setTitle("spring Data Jpa");
        post3Repository.save(post3);

        List<Post3> all = post3Repository.findByTitle("spring Data Jpa");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByCreatedAfter() {
        Post3 post3 = new Post3();
        post3.setTitle("spring Data Jpa");
        post3Repository.save(post3);

        Date date = new Date();
        date.setTime(System.currentTimeMillis() - 100000);

        List<Post3> all = post3Repository.findByCreatedAfter(date);
        assertThat(all.size()).isEqualTo(1);
    }
}