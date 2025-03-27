package com.example.store.client;
import java.util.Optional;

public interface ClientItf {
	 Client register(String email, String password, String nom, String prenom);
	 Optional<Client> login(String email, String password);


}
