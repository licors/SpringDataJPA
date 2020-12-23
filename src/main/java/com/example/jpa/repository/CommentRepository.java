package com.example.jpa.repository;

import com.example.jpa.Comment;
import org.springframework.data.repository.RepositoryDefinition;

// MyRepository 상속 안받고 해당 리파지토리만 구현하는 경우 아래 애노테이션 추가하고 함수들 구현r
// @RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{
}
