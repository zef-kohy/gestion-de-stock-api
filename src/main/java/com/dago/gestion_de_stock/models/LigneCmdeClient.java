package com.dago.gestion_de_stock.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ligne_de_commande_client")
public class LigneCmdeClient extends AbstractEntity {

    @NotEmpty(message = "la quantité est obligatoire")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @NotEmpty(message = "L'article est obligatoire")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "commandeFournisseur_id")
    @NotEmpty(message = "La commande est obligatoire")
    private CommandeFournisseur commandeFournisseur;
}