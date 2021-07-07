package ru.mngerasimenko.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mngerasimenko.bank.dao.ClientRepository;
import ru.mngerasimenko.bank.domain.Client;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findByFio() {
        return null;
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }
}
