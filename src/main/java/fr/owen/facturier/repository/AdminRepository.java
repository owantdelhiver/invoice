package fr.owen.facturier.repository;

import fr.owen.facturier.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByMail(String email);
}
