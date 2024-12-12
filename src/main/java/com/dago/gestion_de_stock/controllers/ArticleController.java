package com.dago.gestion_de_stock.controllers;

import com.dago.gestion_de_stock.dto.ArticleDto;
import com.dago.gestion_de_stock.services.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<ArticleDto> createArticle(@Valid @RequestBody ArticleDto articleDto){
        return ResponseEntity.ok(articleService.createArticle(articleDto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ArticleDto>> getArticles(){
        return ResponseEntity.ok(articleService.getArticles());
    }

    @GetMapping("/getone/{idArticle}")
    ResponseEntity<ArticleDto> getArticleById(@PathVariable Long idArticle){
        return createArticle(articleService.getArticleById(idArticle));
    }

    @PutMapping("/{idArticle}/edit")
    ResponseEntity<ArticleDto> updateArticle(@PathVariable Long idArticle, @RequestBody ArticleDto articleDto){
        return ResponseEntity.ok(articleService.updateArticle(idArticle, articleDto));
    }

    @GetMapping("/code/{code}")
    ResponseEntity<ArticleDto> getArticleByCode(@PathVariable("code") String code){
        return ResponseEntity.ok(articleService.getArticleByCode(code));
    }

    @GetMapping("/motCle/{designation}")
    ResponseEntity<List<ArticleDto>> getArticlesByDesignationContaining(@PathVariable("designation") String designation){
        return ResponseEntity.ok(articleService.getArticlesByDesignationContaining(designation));
    }

    @GetMapping("/{idCategorie}")
    ResponseEntity<List<ArticleDto>> getArticleByCategorie(@PathVariable("idCategorie") Long idCategorie){
        return ResponseEntity.ok(articleService.getArticleByCategorie(idCategorie));
    }

    @DeleteMapping("/{idArticle}")
    void deleteArticleById(@PathVariable Long idArticle){
        articleService.deleteArticleById(idArticle);
    }
}
