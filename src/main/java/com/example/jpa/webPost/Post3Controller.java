package com.example.jpa.webPost;

import com.example.jpa.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Post3Controller {

    // Autowired 대신에 생성자 구현도 가능
    @Autowired
    Post3Repository post3Repository;

//    @GetMapping("/posts/{id}")
//    public String getPost(@PathVariable Long id) {
//        Optional<Post3> byId = post3Repository.findById(id);
//        // get 써서 null 나올수도 있다.
//        Post3 post3 = byId.get();
//        return post3.getTitle();
//    }

    // 위 주석과 동작 동일, DomainClassConverter 이용한 코드
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable("id") Post3 post3) {
        return post3.getTitle();
    }
}
