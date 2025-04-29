package com.fraudanalysis.application.dtos;


public record FraudRequestDTO(
        Double amount,
        String paymentMethod,
        String paymentDate,
        Long orderId
) {}

