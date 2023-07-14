package com.example.spring.service.impl;

import com.example.spring.entity.MemberEntity;
import com.example.spring.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Optional<MemberEntity> loginMember(String email, String password) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberEntity> registerMember(String email, String userName) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberEntity> findMemberById(Long id) {
        return Optional.empty();
    }

    @Override
    public void createOrUpdateMember(MemberEntity member) {

    }
}