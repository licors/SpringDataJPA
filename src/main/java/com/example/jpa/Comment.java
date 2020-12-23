package com.example.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    // @ManyToOne 기본 설정은 FetchType.EAGER
    @ManyToOne
    private Post post;

    // 클래스로 선언하면 테이블에서 널 값으로 기본세팅됨, 그래서 널이 안들어가도록 0 기본값 넣어줌
    private Integer likeCount = 0;

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
