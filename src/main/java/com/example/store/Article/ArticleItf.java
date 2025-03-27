package com.example.store.Article;

public interface ArticleItf {
    Article create(String libelle,int quantite,double prix);
    void delete(Long id_article);
}
