package com.example.store.Commande;
import com.example.store.Article.Article;
import com.example.store.client.Client;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Long id_commande;

    private String nom_comm;

    @ManyToOne
    private Client client;

    @OneToMany
    private List<Article> articles;

    public Commande() {
    }

    public Commande(String nom_comm, Client client, List<Article> articles) {
        this.nom_comm = nom_comm;
        this.client = client;
        this.articles = articles;
    }

    public Long getId_commande() {
        return id_commande;
    }

    public Client getClient() {
        return client;
    }

    public String getNom_comm() {
        return nom_comm;
    }

    public void setNom_comm(String nom_comm) {
        this.nom_comm = nom_comm;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
