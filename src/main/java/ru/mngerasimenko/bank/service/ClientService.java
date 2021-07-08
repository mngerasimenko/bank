package ru.mngerasimenko.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mngerasimenko.bank.dao.ClientRepository;
import ru.mngerasimenko.bank.domain.Client;
import ru.mngerasimenko.bank.exception.DaoException;

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

    public List<Client> findByFio(String fio) {
        return clientRepository.findClientByFioContains(fio);
    }

    public List<Client> findByTelephone(String telephone) {
        return clientRepository.findClientByTelephoneContains(telephone);
    }
    public List<Client> findByFioAndTelephone(String fio, String telephone) {
        return clientRepository.findClientByFioContainsAndTelephoneContains(fio, telephone);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(UUID id) throws DaoException {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Client getById(UUID clientId) {
        return clientRepository.getById(clientId);
    }



}
