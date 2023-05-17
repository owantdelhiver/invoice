package fr.owen.facturier.model.facture;

import java.time.LocalDate;

public class FactureEdit {
    private LocalDate date;
    private int id_client;

    public FactureEdit() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}
