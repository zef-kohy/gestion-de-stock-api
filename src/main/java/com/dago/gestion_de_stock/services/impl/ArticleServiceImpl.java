package com.dago.gestion_de_stock.services.impl;

import com.dago.gestion_de_stock.dto.ArticleDto;
import com.dago.gestion_de_stock.models.Article;
import com.dago.gestion_de_stock.models.Categorie;
import com.dago.gestion_de_stock.repositories.ArticleRepo;
import com.dago.gestion_de_stock.repositories.CategorieRepo;
import com.dago.gestion_de_stock.services.ArticleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepo articleRepo;
    private final CategorieRepo categorieRepo;
    private final ModelMapper modelMapper;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        /*Categorie foundCategorie = categorieRepo.findCategorieByNomCategorie(articleDto.categorie().getNomCategorie());
        articleDto.categorie().setNomCategorie(foundCategorie.getNomCategorie());*/
        return convertEntityToDto(articleRepo.save(convertDtoToEntity(articleDto)));
    }

    @Override
    public ArticleDto updateArticle(Long articleId, ArticleDto articleDto) {
        Optional<Article> article = articleRepo.findById(articleId);
        if (article.isPresent()) {

            Article foundArticle = article.get();
            foundArticle.setId(articleDto.idArticle());
            foundArticle.setCodeArticle(articleDto.codeArticle());
            foundArticle.setLibelleArticle(articleDto.libelleArticle());
            foundArticle.setPrixUnitaireArticleHT(articleDto.prixUnitaireArticleHT());
            foundArticle.setTauxTVA(articleDto.tauxTVA());
            foundArticle.setPrixUnitaireArticleTTC(articleDto.prixUnitaireArticleTTC());
            foundArticle.setPhotoArticle(articleDto.photoArticle());
            foundArticle.setCategorie(articleDto.categorie());

            return convertEntityToDto(articleRepo.save(foundArticle));
        }
        throw new EntityNotFoundException("Article with id " + articleId + " not found");
    }

    @Override
    public ArticleDto getArticle(Long articleId) {
        Optional<Article> foundArticle = articleRepo.findById(articleId);
        if (foundArticle.isPresent()) {
            return convertEntityToDto(foundArticle.get());
        }
        throw new EntityNotFoundException("Article not found");
    }

    @Override
    public List<ArticleDto> getArticles() {
        return articleRepo.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(Long articleId) {
        getArticle(articleId);
        articleRepo.deleteById(articleId);

    }

    @Override
    public List<ArticleDto> getArticleByLibelle(String libelle) {
        return articleRepo.findByLibelleArticle(libelle)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findByLibelleArticleContainingIgnoreCase(String motCle) {
        return articleRepo.findByLibelleArticleContainingIgnoreCase(motCle).stream()
                .map(this::convertEntityToDto)
                .toList();

    }

    @Override
    public List<ArticleDto> findArticleByPrixUnitaireArticleHT(Double prixUnitaire) {
        return articleRepo.findArticleByPrixUnitaireArticleHT(prixUnitaire).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findArticleByPrixUnitaireArticleHTBefore(Double prixUnitaire) {
        return articleRepo.findArticleByPrixUnitaireArticleHTBefore(prixUnitaire).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findArticleByPrixUnitaireArticleHTIsAfter(Double prixUnitaire) {
        return articleRepo.findArticleByPrixUnitaireArticleHTIsAfter(prixUnitaire).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findArticleByCategorieId(Long categorieId) {
        return articleRepo.findArticleByCategorieId(categorieId).stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto convertEntityToDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

    @Override
    public Article convertDtoToEntity(ArticleDto articleDto) {
        return modelMapper.map(articleDto, Article.class);
    }
}
