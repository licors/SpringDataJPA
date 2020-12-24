package com.example.jpa.repository2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Post2Repository extends JpaRepository<Post2, Long>, Post2CustomRepository {
}
