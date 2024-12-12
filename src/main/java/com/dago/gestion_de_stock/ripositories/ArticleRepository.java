package com.dago.gestion_de_stock.ripositories;

import com.dago.gestion_de_stock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findArticleByCodeArticle(String code);


    List<Article> findArticlesByCategorieId(Long idCategorie);

    List<Article> findArticlesByDesignationContaining(String motCle);
}
