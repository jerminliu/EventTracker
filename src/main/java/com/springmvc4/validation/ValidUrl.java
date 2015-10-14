package com.springmvc4.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy={ValidUrlValidator.class})
public @interface ValidUrl {

    String message() default "{com.springmvc4.validation.ValidUrl.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String protocol() default "";

    String host() default "";

    int port() default -1;

    @Target({ METHOD, FIELD })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        ValidUrl[] value();
    }
}
