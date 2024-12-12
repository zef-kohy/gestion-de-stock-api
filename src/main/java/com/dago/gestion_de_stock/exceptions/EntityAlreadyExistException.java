package com.dago.gestion_de_stock.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
public class EntityAlreadyExistException extends RuntimeException{
    private final Set<String> errorMessages;
}
