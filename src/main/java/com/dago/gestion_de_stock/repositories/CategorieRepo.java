package com.dago.gestion_de_stock.repositories;

import com.dago.gestion_de_stock.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {

    List<Categorie> findByNomCategorie(String nom);

    Categorie findCategorieByNomCategorie(String nom);

    List<Categorie> findByNomCategorieContaining(String motCle);
}
