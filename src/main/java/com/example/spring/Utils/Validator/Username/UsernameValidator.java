package com.example.spring.Utils.Validator.Username;

import com.example.spring.entity.MemberEntity;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements
        ConstraintValidator<UsernameConstraint, String> {
    @Autowired
    private final MemberService memberService;

    public UsernameValidator(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void initialize(UsernameConstraint username) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        MemberEntity existingMember = memberService.findMemberByUsername(contactField);
        return existingMember == null;
    }
}
