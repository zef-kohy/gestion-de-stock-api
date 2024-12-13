package com.dago.gestion_de_stock.controllers;

import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.services.CategorieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping("/create")
    public ResponseEntity<CategorieDto> createCategorie(@RequestBody CategorieDto categorieDto) {
        return ResponseEntity.ok(categorieService.createCategorie(categorieDto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CategorieDto>> getAllCategories() {
        return ResponseEntity.ok(categorieService.getAllCategories());
    }
    @GetMapping("/findByNom/{nomCategorie}")
    public ResponseEntity<List<CategorieDto>> getAllCategoriesByNomCategorie(@PathVariable String nomCategorie) {
        return ResponseEntity.ok(categorieService.getAllCategoriesByNom(nomCategorie));
    }
    @GetMapping("/find/{motCle}")
    public ResponseEntity<List<CategorieDto>> getAllCategoriesByNomCategorieContaining(@PathVariable String motCle) {
        return ResponseEntity.ok(categorieService.getAllCategoriesByNomContaining(motCle));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CategorieDto> getCategorieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categorieService.getCategorieById(id));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<CategorieDto> updateCategorie(@PathVariable("id") Long id, @RequestBody CategorieDto categorieDto) {
        return ResponseEntity.ok(categorieService.updateCategorie(id, categorieDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategorieDto> deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorieById(id);
        return ResponseEntity.noContent().build();
    }
}
