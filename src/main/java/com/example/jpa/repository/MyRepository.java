package com.example.jpa.repository;

import com.example.jpa.Comment;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

// 임의 구현시 공통부분 인터페이스로 따로 빼고 싶을 때 아래와 같이 구현
@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {
    <E extends T> E save(E comment);

    List<T> findAll();

    long count();

    @Nullable
    <E extends T> Optional<E> findById(Id id);
}
