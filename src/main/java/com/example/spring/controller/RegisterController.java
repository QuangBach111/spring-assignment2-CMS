package com.example.spring.controller;

import com.example.spring.model.Register;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private MemberService memberService;

    @GetMapping({"", "/save"})
    public String showRegistrationForm(Model model) {
        Register user = new Register();
        model.addAttribute("user", user);
        return "/register/register-form";
    }

    @PostMapping("/save")
    public String saveRegistrationForm(@Valid @ModelAttribute("user") Register register,
                                       BindingResult result,
                                       Model model) {
        if (!register.getPassword().equals(register.getRePassword())) {
            result.rejectValue("rePassword", null, "Password and Confirm Password not match");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", register);
            return "/register/register-form";
        }

        memberService.saveMember(register);

        return "redirect:/register?success";
    }
}