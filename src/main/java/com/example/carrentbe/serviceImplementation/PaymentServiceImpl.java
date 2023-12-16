package com.example.carrentbe.serviceImplementation;
import com.example.carrentbe.model.Payment;
import com.example.carrentbe.repository.PaymentRepository;
import com.example.carrentbe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.orElse(null);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        if (payment != null && payment.getPaymentId() != null && paymentRepository.existsById(payment.getPaymentId())) {
            return paymentRepository.save(payment);
        } else {
            return null;
        }
    }

    @Override
    public void deletePayment(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
