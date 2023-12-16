package com.example.carrentbe.service;
import com.example.carrentbe.model.Payment;
import java.util.List;
public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer paymentId);
    Payment updatePayment(Payment payment);
    void deletePayment(Integer paymentId);
}
