package com.dago.gestion_de_stock.models;

import com.dago.gestion_de_stock.enumerations.SourceMouvement;
import com.dago.gestion_de_stock.enumerations.TypeDeMouvement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mouvement_de_stock")
public class MouvementDeStock extends AbstractEntity{

    @NotEmpty(message = "Veuillez renseigner la date du mouvement")
    private Instant dateMouvement;

    @NotEmpty(message = "renseigner une quantité")
    @Positive(message = "la quantité doit être supérieur à zéro")
    private int quantiteMouvement;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @NotEmpty(message = "veuillez renseigner l'article")
    private Article article;

    @NotNull(message = "veuillez sélectionner la source du mouvement")
    @Enumerated(EnumType.STRING)
    private TypeDeMouvement typeDeMouvement;

    @NotNull(message = "la source est obligatoire")
    @Enumerated(EnumType.STRING)
    private SourceMouvement sourceMouvement;


}
