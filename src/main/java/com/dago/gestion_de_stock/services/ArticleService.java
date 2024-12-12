package com.dago.gestion_de_stock.services;

import com.dago.gestion_de_stock.dto.ArticleDto;
import com.dago.gestion_de_stock.dto.CategorieDto;
import com.dago.gestion_de_stock.models.Article;
import com.dago.gestion_de_stock.models.Categorie;

import java.util.List;

public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);

    ArticleDto updateArticle(Long idArticle, ArticleDto articleDto);

    ArticleDto getArticleById(Long idArticle);

    ArticleDto getArticleByCode(String code);

    List<ArticleDto> getArticles();

    List<ArticleDto> getArticlesByDesignationContaining(String designation);

    List<ArticleDto> getArticleByCategorie(Long idCategorie);

    void deleteArticleById(Long idArticle);

    ArticleDto convertEntityToDto(Article article);

    Article convertDtoToEntity(ArticleDto articleDto);



}
