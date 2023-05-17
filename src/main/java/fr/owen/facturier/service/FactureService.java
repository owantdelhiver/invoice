package fr.owen.facturier.service;

import fr.owen.facturier.model.facture.Facture;
import fr.owen.facturier.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    @Autowired
    FactureRepository factureRepository;
    public List<Facture> fetchAll() {
        return factureRepository.findAll();
    }
    public Facture fetchById(int id) {
        return factureRepository.findById(id).get();
    }
    public void save(Facture facture) {
        factureRepository.save(facture);
    }

    public void delete(int id) {
        factureRepository.deleteById(id);
    }
}