package com.example.store.Commande;

import com.example.store.Article.Article;
import com.example.store.client.Client;

import java.util.List;

public interface CommandeItf {
    Commande create(String nom_comm,Client client, List<Article> articles);
    List<Commande> findByClient(Client client);
    Commande findById(Long id_commande);
    void delete(Long id_commande);

}
