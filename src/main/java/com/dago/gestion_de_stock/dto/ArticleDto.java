package com.dago.gestion_de_stock.dto;

import com.dago.gestion_de_stock.models.Categorie;
import lombok.Data;


public record ArticleDto(
        Long idArticle,
        String codeArticle,
        String libelleArticle,
        Double prixUnitaireArticleHT,
        Double tauxTVA,
        Double prixUnitaireArticleTTC,
        String photoArticle,
        Categorie categorie
) {
}
