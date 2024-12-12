package com.dago.gestion_de_stock.services.impl;

import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.models.Categorie;
import com.dago.gestion_de_stock.ripositories.CategorieRepository;
import com.dago.gestion_de_stock.services.CategorieService;
import com.dago.gestion_de_stock.validators.EntityValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;
    private final ModelMapper modelMapper;
    private final EntityValidator<CategorieDto> entityValidator;

    @Override
    public CategorieDto postCategorie(CategorieDto categorie) {
        entityValidator.validate(categorie);
        return convertEntityToDto(
                categorieRepository.save(convertDtoToEntity(categorie)));
    }

    @Override
    public List<CategorieDto> getAllCategories() {
        return categorieRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<CategorieDto> getAllCategoriesByDesignationContaining(String designation) {
        return categorieRepository.findCategorieByNomCategorieContaining(designation).stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public CategorieDto getCategorieById(Long idCategorie) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(idCategorie);
        if (optionalCategorie.isPresent()) {
            return convertEntityToDto(optionalCategorie.get());
        }
        throw new RuntimeException("la catégorie avec l'id : " + idCategorie + "n'a pas été trouvée");
    }

    @Override
    public void deleteCategorieById(Long idCategorie) {
        getCategorieById(idCategorie);
        categorieRepository.deleteById(idCategorie);

    }

    @Override
    public CategorieDto updateCategorie(Long id, CategorieDto categorieDto) {
        getCategorieById(id);
        categorieDto.setIdCategorie(categorieDto.getIdCategorie());
        categorieDto.setCode(categorieDto.getCode());
        categorieDto.setNomCategorie(categorieDto.getNomCategorie());

        return convertEntityToDto(categorieRepository.save(convertDtoToEntity(categorieDto)));
    }

    @Override
    public CategorieDto findCategorieByDesignation(String designation) {
        return convertEntityToDto(categorieRepository.findCategorieByNomCategorie(designation));
    }

    @Override
    public CategorieDto findCategorieByCode(String code) {
        return convertEntityToDto(categorieRepository.findCategorieByCode(code));
    }

    @Override
    public Categorie convertDtoToEntity(CategorieDto categorieDto) {

        Categorie categorie = new Categorie();
        categorie = modelMapper.map(categorieDto, Categorie.class);

        return categorie;
    }

    @Override
    public CategorieDto convertEntityToDto(Categorie categorie) {
        CategorieDto categorieDto = modelMapper.map(categorie, CategorieDto.class);

        return categorieDto;
    }
}