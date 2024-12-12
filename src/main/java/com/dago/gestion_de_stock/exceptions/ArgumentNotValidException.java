package com.dago.gestion_de_stock.exceptions;

import lombok.Data;

import java.util.Set;

@Data
public class ArgumentNotValidException extends RuntimeException {

    private final Set<String> errors;
}
