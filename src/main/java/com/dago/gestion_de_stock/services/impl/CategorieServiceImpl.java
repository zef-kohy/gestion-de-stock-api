package com.dago.gestion_de_stock.services.impl;

import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.models.Categorie;
import com.dago.gestion_de_stock.repositories.CategorieRepo;
import com.dago.gestion_de_stock.services.CategorieService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepo categorieRepo;

    @Override
    public CategorieDto createCategorie(CategorieDto categorieDto) {

        return convertEntityToDto(categorieRepo.save(convertDtoToEntity(categorieDto)));
    }

    @Override
    public CategorieDto updateCategorie(Long id, CategorieDto categorieDto) {
        Optional<Categorie> categorie = categorieRepo.findById(id);
        if (categorie.isPresent()) {
            Categorie categorieEntity = categorie.get();
            categorieEntity.setId(categorieDto.getIdCategorie());
            categorieEntity.setCodeCategorie(categorieDto.getCodeCategorie());
            categorieEntity.setNomCategorie(categorieDto.getNomCategorie());

            return convertEntityToDto(categorieRepo.save(categorieEntity));
        }
        throw new EntityNotFoundException("La catégorie avec l'id " + id + " n'a pas été trouvé");
    }

    @Override
    public CategorieDto getCategorieById(Long id) {
        Optional<Categorie> categorie = categorieRepo.findById(id);
        if (categorie.isPresent()) {
            return convertEntityToDto(categorie.get());
        }
        throw new EntityNotFoundException("La catégorie avec l'id " + id + " n'a pas été trouvé");
    }

    @Override
    public List<CategorieDto> getAllCategories() {
        return categorieRepo.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategorieDto> getAllCategoriesByNom(String nomCategorie) {
        return categorieRepo.findByNomCategorie(nomCategorie).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategorieDto> getAllCategoriesByNomContaining(String nom) {
        return categorieRepo.findByNomCategorieContaining(nom).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategorieById(Long id) {
        Optional<Categorie> categorie = categorieRepo.findById(id);
        if (categorie.isPresent()) {
            categorieRepo.deleteById(id);
        }
        throw new EntityNotFoundException("La catégorie avec l'id " + id + "n'a pas été trouvée");

    }

    @Override
    public CategorieDto convertEntityToDto(Categorie categorie) {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setIdCategorie(categorie.getId());
        categorieDto.setCodeCategorie(categorie.getCodeCategorie());
        categorieDto.setNomCategorie(categorie.getNomCategorie());

        return categorieDto;
    }

    @Override
    public Categorie convertDtoToEntity(CategorieDto categorieDto) {
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getIdCategorie());
        categorie.setCodeCategorie(categorieDto.getCodeCategorie());
        categorie.setNomCategorie(categorieDto.getNomCategorie());

        return categorie;
    }
}
