package com.PatitosdeHule.eCommerce.services.implement;


import com.PatitosdeHule.eCommerce.DTOs.ArticleDTO;
import com.PatitosdeHule.eCommerce.models.Article;
import com.PatitosdeHule.eCommerce.repositories.ArticleRepository;
import com.PatitosdeHule.eCommerce.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleImplementService implements ArticleService {

    
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Set<ArticleDTO> getArticlesDTOs() {
        return articleRepository.findAll().stream().map(ArticleDTO::new).collect(Collectors.toSet());
    }


}
