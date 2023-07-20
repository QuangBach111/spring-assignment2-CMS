package com.example.spring.service;

import com.example.spring.dto.LoginRequestDTO;

public interface LoginService {
    String doLogin(LoginRequestDTO loginRequestDTO);
}