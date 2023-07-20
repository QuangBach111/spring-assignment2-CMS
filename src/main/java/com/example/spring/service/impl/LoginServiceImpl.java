package com.example.spring.service.impl;

import com.example.spring.dto.LoginRequestDTO;
import com.example.spring.entity.MemberEntity;
import com.example.spring.repository.MemberRepository;
import com.example.spring.service.LoginService;
import com.example.spring.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String doLogin(LoginRequestDTO loginRequestDTO) {
        Optional<MemberEntity> memberEntity = memberRepository.findByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

        return memberEntity.isPresent() ? jwtUtil.generateJwt(memberEntity.get()) : null;
    }
}