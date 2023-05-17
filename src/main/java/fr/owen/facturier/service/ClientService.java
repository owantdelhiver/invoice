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

    public Client fetchById(int id) {
        return clientRepository.findById(id).get();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void delete(int id){
        clientRepository.deleteById(id);
    }
}
