package com.example.getmeapi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidationNameValidator.class)
@Documented
public @interface ValidName {
    String message() default "Not a valid name";

    Class<?>[] group() default {};
    Class<? extends Payload>[] payload() default {};
}
