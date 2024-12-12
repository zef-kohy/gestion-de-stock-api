package com.dago.gestion_de_stock.validators;

import com.dago.gestion_de_stock.exceptions.EntityNotValidException;
import com.dago.gestion_de_stock.exceptions.MethodArgumentException;
import jakarta.validation.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EntityValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private final Validator validator = factory.getValidator();

    public void validate(T entityToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(entityToValidate);

        if (!violations.isEmpty()){
            var message = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new MethodArgumentException(message);
        }
    }
}
