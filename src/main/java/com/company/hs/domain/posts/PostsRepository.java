package com.company.hs.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Entity 클래스와 Entity Repository 클래스는 함께 위치해야함.

public interface PostsRepository extends JpaRepository<Posts,Long> { // JpaRepository<Entity클래스,PK타입>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
