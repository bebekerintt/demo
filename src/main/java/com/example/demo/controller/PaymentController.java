package com.example.demo.controller;

import com.example.demo.service.PaymentService;
import com.example.demo.model.Payment;
import com.example.demo.dto.PaymentRequestDTO;
import com.example.demo.dto.PaymentsRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    // Endpoint para listar todos los pagos
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Endpoint para registrar un nuevo pago
    @PostMapping("/register")
    public ResponseEntity<Payment> registerPayment(@RequestBody PaymentRequestDTO paymentRequest) {
        Payment savedPayment = paymentService.registerPayment(paymentRequest);
        return ResponseEntity.status(201).body(savedPayment);
    }

    @PostMapping("/registerMultiple")
    public ResponseEntity<List<Payment>> registerMultiplePayments(@RequestBody PaymentsRequestDTO paymentsRequest) {
        List<Payment> savedPayments = paymentService.registerMultiplePayments(paymentsRequest);
        return ResponseEntity.status(201).body(savedPayments);
    }

}
