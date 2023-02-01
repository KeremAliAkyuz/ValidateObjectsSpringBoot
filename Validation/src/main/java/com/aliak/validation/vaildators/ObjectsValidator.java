package com.aliak.validation.vaildators;

import com.aliak.validation.models.Greeting;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component //service de kullanılabilir
public class ObjectsValidator<T> {
    //aims for building the default validator factory
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    //factorye git ve validator döndür
    private final Validator validator = factory.getValidator();

    public Set<String> validate (T objectToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);//violations seti döndürür
        if(!violations.isEmpty()){//violation varsa
            return violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }

        return Collections.emptySet();
    }
}
