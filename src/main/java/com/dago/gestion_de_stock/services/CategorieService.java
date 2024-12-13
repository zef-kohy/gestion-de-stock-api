package com.dago.gestion_de_stock.services;

import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.models.Categorie;

import java.util.List;

public interface CategorieService {

    CategorieDto createCategorie(CategorieDto categorieDto);

    CategorieDto updateCategorie(Long id, CategorieDto categorieDto);

    CategorieDto getCategorieById(Long id);

    List<CategorieDto> getAllCategories();

    List<CategorieDto> getAllCategoriesByNom(String nom);

    List<CategorieDto> getAllCategoriesByNomContaining(String nom);

    void deleteCategorieById(Long id);

    CategorieDto convertEntityToDto(Categorie categorie);

    Categorie convertDtoToEntity(CategorieDto categorieDto);
}
