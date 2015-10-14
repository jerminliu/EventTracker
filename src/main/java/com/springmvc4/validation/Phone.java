package com.springmvc4.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "{Phone}";    //"{Phone}" should match the properties files i.e. messages_en.properties
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
