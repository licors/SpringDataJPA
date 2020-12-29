package com.example.jpa.webPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface Post3Repository extends JpaRepository<Post3, Long> {

    List<Post3> findByTitleStartsWith(String s);

    List<Post3> findByTitle(String title);

    @Query(value = "select p FROM Post3 as p where p.created > ?1")
    List<Post3> findByCreatedAfter(Date date);
}
