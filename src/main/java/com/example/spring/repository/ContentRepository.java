package com.example.spring.repository;

import com.example.spring.entity.ContentEntity;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
   void deleteContentByIdIn(List<Long> contentId);

    @Query("SELECT c FROM ContentEntity c " +
            "WHERE c.title like %?1% " +
            "or c.brief like %?1% " +
            "or c.content like %?1%")
    List<ContentEntity> findByKeyword(String keyword);
}