package com.example.spring.Utils.Validator.Username;

import com.example.spring.Utils.Validator.Phone.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameConstraint {
    String message() default "{validate.username}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
