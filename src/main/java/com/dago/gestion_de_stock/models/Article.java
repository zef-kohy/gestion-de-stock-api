package com.dago.gestion_de_stock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="articles")
public class Article extends AbstractEntity{

    @NotEmpty(message = "le code ne doit pas être vide")
    private String codeArticle;

    @NotEmpty(message = "le libelle ne doit pas être vide")
    private String libelleArticle;

    @Positive(message = "le prix doit suppérieur à zéro")
    @NotEmpty(message = "le prix ne doit pas être vide")
    private Double prixUnitaireArticleHT;

    @NotEmpty(message = "la TVA ne doit pas être vide")
    @Positive(message = "le taux doit être positif")
    private Double tauxTVA;

    private Double prixUnitaireArticleTTC;

    private String photoArticle;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

}
