package fr.owen.facturier.model.facture;

import fr.owen.facturier.model.client.Client;
import fr.owen.facturier.model.produit.Produit;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    private LocalDate dateEcheance;
    private String paiement;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany
    @JoinTable(name = "facture_product", joinColumns = @JoinColumn(name = "id_facture"), inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Produit> produit;

    public Facture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produit> getProduit() {
        return produit;
    }

    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }
}
