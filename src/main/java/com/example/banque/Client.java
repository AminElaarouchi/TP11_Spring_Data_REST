package com.example.banque;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes = new ArrayList<>();

    protected Client() {}
    public Client(String nom, String email) { this.nom = nom; this.email = email; }
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public List<Compte> getComptes() { return comptes; }
}
