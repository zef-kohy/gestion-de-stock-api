package com.dago.gestion_de_stock.exceptions;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data

public class EntityNotValidException extends RuntimeException{

    private final Set<String> errorMessages;
}
