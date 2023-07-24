package com.example.spring.Utils.Validator.Email;

import com.example.spring.entity.MemberEntity;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailConstraint, String> {
    @Autowired
    private final MemberService memberService;

    public EmailValidator(MemberService memberService) {
        this.memberService = memberService;
    }
    @Override
    public void initialize(EmailConstraint email) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        MemberEntity existingMember = memberService.findMemberByUsername(contactField);

        if (contactField == null || contactField.trim().isEmpty()) {
            cxt.disableDefaultConstraintViolation();
            cxt.buildConstraintViolationWithTemplate("{blank.email}")
                    .addConstraintViolation();
            return false;
        }

        if (existingMember != null) {
            return false;
        }

        if (!isValidEmailFormat(contactField)) {
            cxt.disableDefaultConstraintViolation();
            cxt.buildConstraintViolationWithTemplate("{validate.email.format}")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

    private boolean isValidEmailFormat(String email) {
        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailPattern);
    }
}
