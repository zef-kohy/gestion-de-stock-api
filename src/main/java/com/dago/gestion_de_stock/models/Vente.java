package com.dago.gestion_de_stock.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventes")
public class Vente extends AbstractEntity{

    @NotEmpty(message = "la quantité est obligatoire")
    private String codeVente;


    @NotEmpty(message = "la date est obligatoire")
    private Instant dateVente;

    private String commentaire;

    @OneToMany(mappedBy = "vente")
    private List<LigneDeVente> ventes;
}
