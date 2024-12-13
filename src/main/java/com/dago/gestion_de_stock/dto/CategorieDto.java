package com.dago.gestion_de_stock.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategorieDto {

    private Long idCategorie;

    @NotEmpty(message = "le code ne doit pas être vide")
    private String codeCategorie;

    @NotEmpty(message = "Le nom ne doit pas être vide")
    private String nomCategorie;

}
