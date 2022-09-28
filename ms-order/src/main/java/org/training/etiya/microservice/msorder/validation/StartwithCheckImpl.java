package org.training.etiya.microservice.msorder.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartwithCheckImpl implements ConstraintValidator<Startwith, String> {

    private Startwith anno;

    @Override
    public void initialize(Startwith annoParam) {
        anno = annoParam;
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        return value.startsWith(anno.value());
    }

}
