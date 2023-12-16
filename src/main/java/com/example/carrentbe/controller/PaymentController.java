package com.example.carrentbe.controller;
import com.example.carrentbe.model.Payment;
import com.example.carrentbe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.savePayment(payment);
        return ResponseEntity.ok(newPayment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Integer id, @RequestBody Payment payment) {
        if (!id.equals(payment.getPaymentId())) {
            return ResponseEntity.badRequest().build();
        }
        Payment updatedPayment = paymentService.updatePayment(payment);
        return updatedPayment != null ? ResponseEntity.ok(updatedPayment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok().build();
    }
}
