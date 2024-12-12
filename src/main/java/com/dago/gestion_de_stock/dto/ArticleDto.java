package com.dago.gestion_de_stock.dto;

import com.dago.gestion_de_stock.models.Article;
import com.dago.gestion_de_stock.models.Categorie;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ArticleDto {

    private Long id;

    @NotEmpty(message = "Le code de l'article est obligatoire")
    private String codeArticle;


    @NotEmpty(message = "Le désignation de l'article est obligatoire")
    private String designation;


    private Double prixUnitaireHt;


    private Double tauxTva;

    private Double montantTva;


    private Double prixUnitaireTtc;


    private String photo;

    private CategorieDto categorie;

    private String  nomCategorie;

    /*private Double prixTTC(){
        this.montantTva = (prixUnitaireHt * tauxTva)/ 100;

        return (prixUnitaireTtc = montantTva + prixUnitaireHt);
    }
*/
}
