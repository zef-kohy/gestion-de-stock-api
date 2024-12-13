package com.dago.gestion_de_stock.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Categorie extends AbstractEntity{

    @NotEmpty(message = "le code ne doit pas être vide")
    private String codeCategorie;

    @NotEmpty(message = "le nom ne doit pas être vide")
    private String nomCategorie;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;

}
