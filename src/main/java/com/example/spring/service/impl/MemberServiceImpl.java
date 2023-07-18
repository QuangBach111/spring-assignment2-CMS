package com.example.spring.service.impl;

import com.example.spring.entity.MemberEntity;
import com.example.spring.repository.MemberRepository;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public Optional<MemberEntity> loginMember(String email, String password) {
        return this.memberRepository.findByEmailAndPassword(email, password);
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