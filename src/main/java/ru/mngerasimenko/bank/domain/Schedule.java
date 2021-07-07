package ru.mngerasimenko.bank.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "bk_schedule")
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private UUID scheduleId;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "payment_am")
    private Double paymentAm;
    @Column(name = "body_am")
    private Double bodyAm;
    @Column(name = "percent_am")
    private Double percentAm;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public UUID getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(UUID scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getPaymentAm() {
        return paymentAm;
    }

    public void setPaymentAm(Double paymentAm) {
        this.paymentAm = paymentAm;
    }

    public Double getBodyAm() {
        return bodyAm;
    }

    public void setBodyAm(Double bodyAm) {
        this.bodyAm = bodyAm;
    }

    public Double getPercentAm() {
        return percentAm;
    }

    public void setPercentAm(Double percentAm) {
        this.percentAm = percentAm;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
