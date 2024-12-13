package com.dago.gestion_de_stock.exceptions;

public record ErrorResponse(
        int status,
        String message
) {
}
