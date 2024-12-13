package com.dago.gestion_de_stock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
@Table(name = "entreprises")
public class Entreprise extends AbstractEntity{

    @NotEmpty(message = "le nom de l'entreprise est obligatoire")
    private String nomEntreprise;

    private String description;

    @Embedded
    private Adresse adresse;

    private String codeFiscal;

    private String photo;

    @NotEmpty(message = "le nom de l'entreprise est obligatoire")
    private String email;

    @NotEmpty(message = "le numéro de téléphone de l'entreprise est obligatoire")
    private String numTel;

    private String steWeb;

}
