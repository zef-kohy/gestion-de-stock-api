package com.dago.gestion_de_stock.services;

import com.dago.gestion_de_stock.dto.ArticleDto;
import com.dago.gestion_de_stock.models.Article;

import java.util.List;

public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);
    ArticleDto updateArticle(Long articleId, ArticleDto articleDto);
    ArticleDto getArticle(Long articleId);
    List<ArticleDto> getArticles();
    void deleteArticle(Long articleId);
    List<ArticleDto> getArticleByLibelle(String libelle);

    List<ArticleDto> findByLibelleArticleContainingIgnoreCase(String motCle);

    List<ArticleDto> findArticleByPrixUnitaireArticleHT(Double prixUnitaire);

    List<ArticleDto> findArticleByPrixUnitaireArticleHTBefore(Double prixUnitaire);

    List<ArticleDto> findArticleByPrixUnitaireArticleHTIsAfter(Double prixUnitaire);

    List<ArticleDto> findArticleByCategorieId(Long categorieId);

    ArticleDto convertEntityToDto(Article article);
    Article convertDtoToEntity(ArticleDto articleDto);
}
