package ru.mngerasimenko.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mngerasimenko.bank.domain.Client;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findClientByFioContains(String fio);

    List<Client> findClientByFioContainsAndTelephoneContains(String fio, String telephone);

    List<Client> findClientByTelephoneContains(String telephone);

}
