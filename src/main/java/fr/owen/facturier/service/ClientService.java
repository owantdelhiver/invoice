package fr.owen.facturier.service;

import fr.owen.facturier.model.client.Client;
import fr.owen.facturier.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
     @Autowired
    ClientRepository clientRepository;
    public List<Client> fetchAll() {
        return clientRepository.findAll();
    }
}
