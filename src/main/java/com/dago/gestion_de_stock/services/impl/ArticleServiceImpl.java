package com.dago.gestion_de_stock.services.impl;

import com.dago.gestion_de_stock.dto.ArticleDto;
import com.dago.gestion_de_stock.models.Article;
import com.dago.gestion_de_stock.ripositories.ArticleRepository;
import com.dago.gestion_de_stock.services.ArticleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        return convertEntityToDto(
                articleRepository.save(convertDtoToEntity(articleDto)));
    }

    @Override
    public ArticleDto updateArticle(Long idArticle, ArticleDto articleDto) {

        ArticleDto foundArticle = getArticleById(idArticle);

        foundArticle.setId(articleDto.getId());
        foundArticle.setCodeArticle(articleDto.getCodeArticle());
        foundArticle.setDesignation(articleDto.getDesignation());
        foundArticle.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        foundArticle.setTauxTva(articleDto.getTauxTva());
        foundArticle.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        foundArticle.setPhoto(articleDto.getPhoto());
        foundArticle.setCategorie(articleDto.getCategorie());

        return convertEntityToDto(articleRepository.save(convertDtoToEntity(foundArticle)));
    }

    @Override
    public ArticleDto getArticleById(Long idArticle) {
        Optional<Article> optionalArticle = articleRepository.findById(idArticle);
        if (optionalArticle.isPresent()){
            return convertEntityToDto(optionalArticle.get());
        }
        throw new EntityNotFoundException("L'article avec l'id " + idArticle + "n'a pas été trouvé");
    }

    @Override
    public ArticleDto getArticleByCode(String code) {
        return convertEntityToDto(articleRepository.findArticleByCodeArticle(code));
    }

    @Override
    public List<ArticleDto> getArticles() {
        return articleRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<ArticleDto> getArticlesByDesignationContaining(String designation) {
        return articleRepository.findArticlesByDesignationContaining(designation).stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<ArticleDto> getArticleByCategorie(Long idCategorie) {
        return articleRepository.findArticlesByCategorieId(idCategorie).stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public void deleteArticleById(Long idArticle) {
        getArticleById(idArticle);
        articleRepository.deleteById(idArticle);

    }

    @Override
    public ArticleDto convertEntityToDto(Article article) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(article, ArticleDto.class);
    }

    @Override
    public Article convertDtoToEntity(ArticleDto articleDto) {
        Article article = new Article();
        article = modelMapper.map(articleDto, Article.class);

        return article;
    }

}
