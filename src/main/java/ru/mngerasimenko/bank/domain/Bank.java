package ru.mngerasimenko.bank.domain;

import javax.persistence.*;
import java.util.UUID;


@Table(name = "bk_bank")
@Entity
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

    public UUID getBankId() {
        return bankId;
    }

    public void setBankId(UUID bankId) {
        this.bankId = bankId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

}
