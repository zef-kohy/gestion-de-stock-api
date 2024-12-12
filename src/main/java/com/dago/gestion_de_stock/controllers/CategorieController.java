package com.dago.gestion_de_stock.controllers;

import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.models.Categorie;
import com.dago.gestion_de_stock.services.CategorieService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping("/all")
    public ResponseEntity<List<CategorieDto>> getAllCategories(){
        return ResponseEntity.ok(categorieService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategorieById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categorieService.getCategorieById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la categorie avec l'id : " + id + "n'a été trouvé");
        }
    }

    @GetMapping("/find/{motCle}")
    public ResponseEntity<List<CategorieDto>> getCategorieByDecription(@PathVariable String motCle){
            return ResponseEntity.ok(categorieService.getAllCategoriesByDesignationContaining(motCle));
    }

    @DeleteMapping("/{idCategorie}")
    public ResponseEntity<?> deleteCategorieById(@PathVariable Long idCategorie){
        try{
            categorieService.deleteCategorieById(idCategorie);
           return ResponseEntity.ok().body("Catégorie supprimée avec succès");

        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategorieDto> updateCategorie(@PathVariable("id") Long id, @RequestBody CategorieDto categorie) {
            categorieService.updateCategorie(id, categorie);
            return ResponseEntity.ok().body(categorie);
    }

    @PostMapping("/create")
    public ResponseEntity<CategorieDto> createCategorie( @RequestBody CategorieDto categorie){

       return ResponseEntity.status(HttpStatus.CREATED).body(categorieService.postCategorie(categorie));
    }

    @GetMapping("/findbynom/{designation}")
    public ResponseEntity<CategorieDto> findCategorieByDesignation(@PathVariable("designation") String designation){
        return ResponseEntity.ok(categorieService.findCategorieByDesignation(designation));
    }

    @GetMapping("/findcode/{code}")
    public ResponseEntity<CategorieDto> findCategorieByCode(@PathVariable String code){
        return ResponseEntity.ok(categorieService.findCategorieByCode(code));
    }
}
