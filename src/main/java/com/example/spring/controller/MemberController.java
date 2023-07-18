package com.example.spring.controller;

import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/user-profile")
    public String viewUserProfile(Model model){
        model.addAttribute("member", model );
        return "member/profile-view";
    }

    @GetMapping("/edit-profile-form/{id}")
    public String showEditProfile(@PathVariable Long id, BindingResult result, Model model){
        memberService.findMemberById(id);
        model.addAttribute("member", model);
        return "member/profile-edit";
    }


}