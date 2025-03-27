package com.example.store.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements ClientItf {

    @Autowired
    private ClientRepository repo;

    @Override
    public Client register(String email, String password, String nom, String prenom) {
        Client client = new Client(email, password, nom, prenom);
        return repo.save(client);
    }

    @Override
    public Optional<Client> login(String email, String password) {
        Client client = repo.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            return Optional.of(client);
        }
        return Optional.empty();
    }
}