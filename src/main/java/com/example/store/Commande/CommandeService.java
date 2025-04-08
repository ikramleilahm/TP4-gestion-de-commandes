package com.example.store.Commande;

import com.example.store.Article.Article;
import com.example.store.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements CommandeItf {

    @Autowired
    private CommandeRepository repo;

    @Override
    public Commande create(String nom_comm,Client client, List<Article> articles) {
        Commande commande = new Commande(nom_comm, client, articles);
        return repo.save(commande);
    }

    @Override
    public List<Commande> findByClient(Client client) {
        return repo.findByClient(client);
    }

    public Commande findById(Long id_commande) {
        return repo.findById(id_commande).orElse(null);
    }

    public Commande save(Commande commande) {
        return repo.save(commande);
    }

    @Override
    public void delete(Long id_commande) {
        repo.deleteById(id_commande);
    }
}
