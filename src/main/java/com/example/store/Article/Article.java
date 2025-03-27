package com.example.store.Article;
import com.example.store.Commande.Commande;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id_article;
    private String libelle;
    private int quantite;
    private double prix;

    @ManyToOne
    private Commande commande;

    public Article() {
    }

    public Article(String libelle, int quantite, double prix) {
        this.libelle = libelle;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Long getId_article() {
        return id_article;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
