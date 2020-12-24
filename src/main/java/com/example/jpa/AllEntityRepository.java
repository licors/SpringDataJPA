package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

// 엔티티 전부에 적용시키는 리파지토리, 기존 함수 없는것 만들 때 따로 만들어줘야 한다.
@NoRepositoryBean
public interface AllEntityRepository<T, Id extends Serializable> extends JpaRepository<T, Id> {

    boolean contains(T entity);
}
