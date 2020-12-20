package com.example.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setUsername("ahm");
//        account.setPassword("pass");
//
//        Study study = new Study();
//        study.setName("Spring Data JPA");
//        study.setOwner(account);
//
//        account.addStudy(study);
//        // unwrap 해서 안에 있는 하이버네이트 사용
//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
//
//
//        Post post = new Post();
//        post.setTitle("Spring Data Jpa 언제 보나...");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 빨리");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("커밍 순");
//        post.addComment(comment1);
//
//        session.save(post);
//        post = session.get(Post.class, 2l);
//        System.out.println(post.getTitle());
//        System.out.println("==================");
//
//        post.getComments().forEach(c -> {
//            System.out.println("-------");
//            System.out.println(c.getComment());
//        });


        // JPQL 사용법
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post as p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        // Criteria, 위 JPQL 타입세이프하게 작성하는 법
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query1 = builder.createQuery(Post.class);
        Root<Post> root = query1.from(Post.class);
        query1.select(root);

        List<Post> posts2 = entityManager.createQuery(query1).getResultList();
        posts2.forEach(System.out::println);

        // Native Query 사용법
        List post3 = entityManager.createNativeQuery("select * from Post", Post.class).getResultList();
        post3.forEach(System.out::println);
    }
}
