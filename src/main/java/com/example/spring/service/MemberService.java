package com.example.spring.service;

import com.example.spring.entity.MemberEntity;
import com.example.spring.model.Register;

import java.util.Optional;

public interface MemberService {
    Optional<MemberEntity> loginMember(String email, String password);
    Optional<MemberEntity> registerMember(String email, String userName);
    Optional<MemberEntity> findMemberById(Long id);
    void createOrUpdateMember(MemberEntity member);
    MemberEntity findMemberByEmail(String email);
    MemberEntity findMemberByUsername(String username);
    void saveMember(Register register);
}