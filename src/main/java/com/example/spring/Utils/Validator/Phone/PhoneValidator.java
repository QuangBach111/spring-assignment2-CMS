package com.example.spring.Utils.Validator.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

        @Override
        public void initialize(PhoneConstraint phoneNumber) {
        }

        @Override
        public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
                if (contactField == null || contactField.trim().isEmpty()) {
                        cxt.disableDefaultConstraintViolation();
                        cxt.buildConstraintViolationWithTemplate("{blank.phone}")
                                .addConstraintViolation();
                        return false;
                }

                return contactField != null && contactField.matches("^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$")
                    && (contactField.length() > 8) && (contactField.length() < 14);
        }
}
