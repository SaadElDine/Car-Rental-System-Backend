package com.example.carrentbe.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    private Integer reservationId;
    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private String paymentMethod;

    // Default constructor
    public Payment() {
    }

    // Constructor with all fields except paymentId
    public Payment(Integer reservationId, Double amount, Date paymentDate, String paymentMethod) {
        this.reservationId = reservationId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    // Constructor with all fields including paymentId
    public Payment(Integer paymentId, Integer reservationId, Double amount, Date paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.reservationId = reservationId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // toString method

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", reservationId=" + reservationId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
