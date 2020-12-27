package com.example.jpa.repository2;

import com.example.jpa.AllEntityRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface Post2Repository extends AllEntityRepository<Post2, Long>, QuerydslPredicateExecutor<Post2> {
}
