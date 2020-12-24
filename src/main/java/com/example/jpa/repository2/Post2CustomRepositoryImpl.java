package com.example.jpa.repository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class Post2CustomRepositoryImpl implements Post2CustomRepository{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post2> findMyPost() {
        System.out.println("custom findMyPost");
        return entityManager.createQuery("SELECT p FROM Post2 AS p", Post2.class)
                .getResultList();
    }
}
