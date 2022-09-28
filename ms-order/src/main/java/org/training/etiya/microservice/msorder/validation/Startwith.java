package org.training.etiya.microservice.msorder.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = StartwithCheckImpl.class)
public @interface Startwith {

    String value();

    String message() default "string {value} ile başlamalı";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
