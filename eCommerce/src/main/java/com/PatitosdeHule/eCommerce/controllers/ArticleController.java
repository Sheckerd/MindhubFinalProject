package com.PatitosdeHule.eCommerce.controllers;

import com.PatitosdeHule.eCommerce.DTOs.ArticleDTO;
import com.PatitosdeHule.eCommerce.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/articles")
    public Set<ArticleDTO> getArticleDTOSet(){
        return articleService.getArticlesDTOs();
    
    }
    

}
