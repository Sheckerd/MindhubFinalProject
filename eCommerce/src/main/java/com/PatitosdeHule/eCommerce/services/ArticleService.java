package com.PatitosdeHule.eCommerce.services;

import com.PatitosdeHule.eCommerce.DTOs.ArticleDTO;
import com.PatitosdeHule.eCommerce.models.Article;

import java.util.Set;

public interface ArticleService {

    void saveArticle (Article article);
    Set<ArticleDTO> getArticlesDTOs();
}
