package com.example.store.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements ArticleItf{

    @Autowired
    private ArticleRepository repo;


    @Override
    public Article create(String libelle, int quantite, double prix) {
        Article article = new Article(libelle, quantite, prix);
        return repo.save(article);
    }

    @Override
    public void delete(Long id_article) {
        repo.deleteById(id_article);
    }

    public Article findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
