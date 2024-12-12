package com.dago.gestion_de_stock.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "articles")
public class Article extends AbstractEntity{

    @Column(name = "code_article")
    @NotEmpty(message = "Le code de l'article est obligatoire")
    private String codeArticle;

    @Column(name = "designation")
    @NotEmpty(message = "Le désignation de l'article est obligatoire")
    private String designation;

    @Column(name = "prix_unitaire_ht")
    @Positive(message = "le prix unitaire doit être suppérieur à zéro")
    private Double prixUnitaireHt;

    @Column(name = "taux_tva")
    @Positive(message = "le taux de la tva doit être positif")
    private Double tauxTva;

    @Column(name = "prix_unitaire_ttc")
    private Double prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;


}
