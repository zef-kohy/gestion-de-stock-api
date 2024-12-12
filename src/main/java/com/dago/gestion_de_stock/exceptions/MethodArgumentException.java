package com.dago.gestion_de_stock.exceptions;

import java.util.Set;

public class MethodArgumentException extends RuntimeException{

    public MethodArgumentException(Set<String> errorMessages) {
    }
}
