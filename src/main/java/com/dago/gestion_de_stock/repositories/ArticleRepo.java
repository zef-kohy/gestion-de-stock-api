package com.dago.gestion_de_stock.repositories;

import com.dago.gestion_de_stock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Long> {

    List<Article> findByLibelleArticle(String libelle);

    List<Article> findByLibelleArticleContainingIgnoreCase(String motCle);

    List<Article> findArticleByPrixUnitaireArticleHT(Double prixUnitaire);

    List<Article> findArticleByPrixUnitaireArticleHTBefore(Double prixUnitaire);

    List<Article> findArticleByPrixUnitaireArticleHTIsAfter(Double prixUnitaire);

    List<Article> findArticleByCategorieId(Long categorieId);

}
