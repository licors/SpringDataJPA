package com.example.jpa.webPost;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface Post3Repository extends JpaRepository<Post3, Long> {

    List<Post3> findByTitleStartsWith(String s);

    List<Post3> findByTitle(String title, Sort sort);

    // :created 는 Named Parameter 기능
    // #{#entityName} 는 SpEL, 위에 엔티티 이름 가져와서 사용
    @Query(value = "select p FROM #{#entityName} as p where p.created > :created")
    List<Post3> findByCreatedAfter(@Param("created") Date date, Sort sort);
}
