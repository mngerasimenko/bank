package ru.mngerasimenko.bank.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "bk_offer")
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private UUID offerId;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id")
    private Credit credit;
    @Column(name = "amount")
    private Double amount;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "offer")
    private List<Schedule> schedules;

    public UUID getOfferId() {
        return offerId;
    }

    public void setOfferId(UUID offerId) {
        this.offerId = offerId;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
