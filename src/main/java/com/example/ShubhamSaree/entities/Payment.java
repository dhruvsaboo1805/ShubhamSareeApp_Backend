package com.example.ShubhamSaree.entities;

import com.example.ShubhamSaree.enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "payment")
public class Payment extends BaseEntity {

    @NotBlank(message = "Payment method is required")
    @Size(max = 50, message = "Payment method must be less than 50 characters")
    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @NotNull(message = "Payment status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false, length = 30)
    private PaymentStatus paymentStatus;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.00", inclusive = true, message = "Amount cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format")
    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Size(max = 100, message = "Transaction ID must be less than 100 characters")
    @Column(name = "transaction_id", length = 100, unique = true)
    private String transactionId; // it will some from payment gateway

}
