package com.example.jpa;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class AllEntityRepositoryImpl<T, Id extends Serializable> extends SimpleJpaRepository<T, Id>
        implements AllEntityRepository<T, Id> {

    private EntityManager entityManager;

    public AllEntityRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }

    // 기존 메소드 오버라이드로 개조 가능
    @Override
    public List<T> findAll() {
        return super.findAll();
    }
}
