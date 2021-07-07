package ru.mngerasimenko.bank.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "bk_client")
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private UUID clientId;
    @Column(name = "fio")
    private String fio;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "passport")
    private String passport;
//    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "client")
//    private List<Bank> banks;
//    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "client")
//    private List<Offer> offers;


}
