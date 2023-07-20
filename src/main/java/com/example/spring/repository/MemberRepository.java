package com.example.spring.repository;

import com.example.spring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Override
    Optional<MemberEntity> findById(Long id);

    Optional<MemberEntity> findByEmailAndPassword(String email, String password);

}