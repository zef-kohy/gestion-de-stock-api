package com.dago.gestion_de_stock.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {

    @NotEmpty(message = "le nom est obligatoire")
    private String firstName;

    @NotEmpty(message = "le prénom est obligatoire")
    private String lastName;

    @NotEmpty(message = "le nom est obligatoire")
    @Email(message = "Votre Email n'est pas valide")
    private String email;

    @NotEmpty(message = "Le numéro de téléphone est obligatoire")
    private String phone;

    @Embedded
    private Adresse address;

    private String photo;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> listCommandes;


}
