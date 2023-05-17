package fr.owen.facturier.service;

import fr.owen.facturier.model.produit.Produit;
import fr.owen.facturier.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> fetchAll() {
        return produitRepository.findAll();
    }

    public Produit fetchById(int id) {
        return produitRepository.findById(id).get();
    }

    public void save(Produit client) {
        produitRepository.save(client);
    }

    public void delete(int id){
        produitRepository.deleteById(id);
    }
}
