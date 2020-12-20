package com.example.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("ahm");
        account.setPassword("pass");

        Study study = new Study();
        study.setName("Spring Data JPA");
        study.setOwner(account);

        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);


        Post post = new Post();
        post.setTitle("Spring Data Jpa 언제 보나...");

        Comment comment = new Comment();
        comment.setComment("빨리 빨리");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("커밍 순");
        post.addComment(comment1);

        session.save(post);
//        post = session.get(Post.class, 2l);
//        System.out.println(post.getTitle());
//        System.out.println("==================");
//
//        post.getComments().forEach(c -> {
//            System.out.println("-------");
//            System.out.println(c.getComment());
//        });
    }
}
