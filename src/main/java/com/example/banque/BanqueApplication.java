package com.example.banque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import java.util.Date;

@SpringBootApplication
public class BanqueApplication {
    public static void main(String[] args) { SpringApplication.run(BanqueApplication.class, args); }

    @Bean
    CommandLineRunner seed(CompteRepository comptes, ClientRepository clients, RepositoryRestConfiguration rest) {
        return args -> {
            rest.exposeIdsFor(Compte.class, Client.class);
            Client amal = clients.save(new Client("Amal", "amal@example.com"));
            Client ali = clients.save(new Client("Ali", "ali@example.com"));
            comptes.save(new Compte(2500, new Date(), TypeCompte.EPARGNE, amal));
            comptes.save(new Compte(1200, new Date(), TypeCompte.COURANT, amal));
            comptes.save(new Compte(3200, new Date(), TypeCompte.EPARGNE, ali));
        };
    }
}
