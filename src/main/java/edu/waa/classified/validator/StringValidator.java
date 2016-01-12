package edu.waa.classified.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<StringSize, String> {
    int min;
    int max;

    @Override
    public void initialize(StringSize constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value == null || value.isEmpty() || value.length() < min || value.length() > max);
    }
}
