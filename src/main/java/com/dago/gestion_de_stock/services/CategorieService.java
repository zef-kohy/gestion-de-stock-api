package com.dago.gestion_de_stock.services;

import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.models.Categorie;

import java.util.List;

public interface CategorieService {

    CategorieDto postCategorie(CategorieDto categorie);

    List<CategorieDto> getAllCategories();
    List<CategorieDto> getAllCategoriesByDesignationContaining(String designation);

    CategorieDto getCategorieById(Long idCategorie);
    void deleteCategorieById(Long idCategorie);

    CategorieDto updateCategorie(Long idCategorie, CategorieDto categorieDto);

    CategorieDto findCategorieByDesignation(String designation);

    CategorieDto findCategorieByCode(String code);
    Categorie convertDtoToEntity(CategorieDto categorieDto);
    CategorieDto convertEntityToDto(Categorie categorie);
}
