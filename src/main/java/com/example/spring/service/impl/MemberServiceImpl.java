package com.example.spring.service.impl;

import com.example.spring.entity.MemberEntity;
import com.example.spring.repository.MemberRepository;
import com.example.spring.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
        return memberRepository.findById(id);
    }

    @Override
    public void updateMember(MemberEntity member) {
        memberRepository.save(member);
    }

    @Override
    public MemberEntity getOne(int id) {
        return memberRepository.getReferenceById((long) id);
    }
}