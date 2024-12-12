package com.dago.gestion_de_stock.ripositories;

import com.dago.gestion_de_stock.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    List<Categorie> findCategorieByNomCategorieContaining(String motCle);

    Categorie findCategorieByNomCategorie(String designation);

    Categorie findCategorieByCode(String code);
}
