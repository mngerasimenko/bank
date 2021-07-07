package ru.mngerasimenko.bank.domain;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "bk_credit")
@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private UUID creditId;
    @Column(name = "limit_am")
    private double limit;
    @Column(name = "percent_am")
    private double percent;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "credit")
    private List<Bank> banks;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "credit")
    private List<Offer> offers;


    public Credit() {
    }

    public Credit(double limit, double percent) {
        this.limit = limit;
        this.percent = percent;
    }

    public UUID getCreditId() {
        return creditId;
    }

    public void setCreditId(UUID creditId) {
        this.creditId = creditId;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditId=" + creditId +
                ", limit=" + limit +
                ", percent=" + percent +
                '}';
    }
}
