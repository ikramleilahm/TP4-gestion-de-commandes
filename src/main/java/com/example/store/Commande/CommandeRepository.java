package com.example.store.Commande;

import com.example.store.client.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {
    List<Commande> findByClient(Client client);
}
