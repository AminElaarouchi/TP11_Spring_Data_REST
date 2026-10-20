package com.example.banque;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    protected Compte() {}
    public Compte(double solde, Date dateCreation, TypeCompte type, Client client) {
        this.solde = solde; this.dateCreation = dateCreation; this.type = type; this.client = client;
    }
    public Long getId() { return id; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
    public Date getDateCreation() { return dateCreation; }
    public TypeCompte getType() { return type; }
    public Client getClient() { return client; }
}
