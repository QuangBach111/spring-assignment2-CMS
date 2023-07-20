package com.example.spring.controller;

import com.example.spring.entity.MemberEntity;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    public static final String ATTRIBUTE_MEMBER_NAME="member";

    @GetMapping("/view-information")
    public String viewInformation(@RequestParam("id") int id  , Model model){
        MemberEntity member = memberService.getOne(id);
        model.addAttribute(ATTRIBUTE_MEMBER_NAME,member);
        return "member/view-profile";
    }

    @GetMapping("/show-form-update")
    public String showFormForUpdate(@RequestParam int id, Model model){
        MemberEntity member = memberService.getOne(id);
        model.addAttribute(ATTRIBUTE_MEMBER_NAME, member);
        return "member/edit-profile";
    }

    @PostMapping("/update-information")
    public String updateInformation(@ModelAttribute MemberEntity member, BindingResult result, Model model ){
        this.memberService.updateMember(member);
        model.addAttribute(ATTRIBUTE_MEMBER_NAME, member);
        return "profile/view-profile";
    }


}