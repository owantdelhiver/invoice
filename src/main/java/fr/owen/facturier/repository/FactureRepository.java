package fr.owen.facturier.repository;

import fr.owen.facturier.model.facture.Facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {
}
