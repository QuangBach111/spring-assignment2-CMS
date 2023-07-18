package com.example.spring.service;

import com.example.spring.entity.MemberEntity;

import java.util.Optional;

public interface MemberService {
    Optional<MemberEntity> loginMember(String email, String password);
    Optional<MemberEntity> registerMember(String email, String userName);
    Optional<MemberEntity> findMemberById(Long id);
    void updateMember(MemberEntity member);
    MemberEntity getOne(int id);



}