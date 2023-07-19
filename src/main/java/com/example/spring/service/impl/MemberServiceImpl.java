package com.example.spring.service.impl;

import com.example.spring.entity.MemberEntity;
import com.example.spring.model.Register;
import com.example.spring.repository.MemberRepository;
import com.example.spring.service.MemberService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

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

    @Override
    public MemberEntity findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public MemberEntity findMemberByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    @Override
    public void saveMember(Register register) {
        MemberEntity member = new MemberEntity();
        member.setUsername(register.getUsername());
        member.setEmail(register.getEmail());
        member.setPhone(register.getPhone());
        // Mã hoá password
        String plainPassword = register.getPassword();
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        member.setPassword(hashedPassword);

        memberRepository.save(member);
    }
}