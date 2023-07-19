package com.example.spring.controller;

import com.example.spring.dto.LoginRequestDTO;
import com.example.spring.entity.MemberEntity;
import com.example.spring.service.LoginService;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@SessionAttributes("accessToken")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/login")
    public String showLogin(@ModelAttribute("newLogin") LoginRequestDTO loginDTO) {
        return "login/login-form";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginRequestDTO loginDTO,
                          BindingResult result,
                          Model model) {
        // error
        if(result.hasErrors()) {
            return "login/login-form";
        }

        String accessToken = loginService.doLogin(loginDTO);
        if(accessToken == null) {
            return "login/login-form";
        }
        model.addAttribute("accessToken", accessToken);
        return "redirect:/content";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}