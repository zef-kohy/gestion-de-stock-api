package com.dago.gestion_de_stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class CategorieDto {


    private Long idCategorie;

    @NotEmpty(message = "le code est obligatoire")
    private String code;

    @NotEmpty(message = "la désignation est obligatoire")
    private String nomCategorie;

    @JsonIgnore
    private List<ArticleDto> articles;

}
