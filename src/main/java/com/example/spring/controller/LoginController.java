package com.example.spring.controller;

import com.example.spring.entity.MemberEntity;
import com.example.spring.model.Login;
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
@SessionAttributes("LoginAu")
public class LoginController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/login")
    public String showLogin(@ModelAttribute("newLogin") Login login) {
        return "login/login-form";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("newLogin") Login login,
                          BindingResult result,
                          Model model) {
        if(result.hasErrors()) {
            return "login/login-form";
        }
        Optional<MemberEntity> member = this.memberService.loginMember(login.getEmail(), login.getPassword());
        if(!member.isPresent()) {
            model.addAttribute("error", "{errorMessage}");
            return "login/login-form";
        }
        model.addAttribute("LoginAu", login);
        return "redirect:/content";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}