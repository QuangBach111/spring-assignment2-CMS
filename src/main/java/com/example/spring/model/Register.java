package com.example.spring.model;

import com.example.spring.Utils.Validator.Email.EmailConstraint;
import com.example.spring.Utils.Validator.Phone.PhoneConstraint;
import com.example.spring.Utils.Validator.Username.UsernameConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Register implements Serializable {
    @NotBlank(message = "{blank.username}")
    @UsernameConstraint
    private String username;
    @EmailConstraint
    private String email;
    @PhoneConstraint
    private String phone;
    @NotBlank(message = "{blank.password}")
    private String password;
    @NotBlank(message = "{blank.repassword}")
    private String rePassword;
}