package com.example.jpa.repository2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Post2RepositoryTest {

    @Autowired
    Post2Repository post2Repository;

    @Test
    public void crud() {
        post2Repository.findMyPost();
    }
}