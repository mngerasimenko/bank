package ru.mngerasimenko.bank.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;


@Table(name = "bk_bank")
@Entity
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private UUID bankId;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id")
    private Credit credit;

}
