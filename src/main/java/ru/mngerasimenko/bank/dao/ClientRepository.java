package ru.mngerasimenko.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mngerasimenko.bank.domain.Client;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

//    @Query(name = "Client.findWithBanks",
//            value = "SELECT cl FROM Client cl " +
//                    "LEFT JOIN FETCH cl.banks")
//    List<Client> findWithBanks();
//
//    @Query(name = "Client.findWithOffers",
//            value = "SELECT cl FROM Client cl " +
//                    "LEFT JOIN FETCH cl.offers")
//    List<Client> findWithOffers();

    Client findClientByFioContains(String fio);


}
