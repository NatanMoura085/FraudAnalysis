//package com.fraudanalysis.infrastructure.adapters;
//
//import com.fraudanalysis.application.dtos.FraudRequestDTO;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PaymentConsumer {
//    private final FraudAnalysisService fraudAnalysisService;
//
//    public PaymentConsumer(FraudAnalysisService fraudAnalysisService) {
//        this.fraudAnalysisService = fraudAnalysisService;
//    }
//
//    @RabbitListener(queues = "payment-queue")
//    public void consumePaymentMessage(FraudRequestDTO fraudRequestDTO) {
//        fraudAnalysisService.analyzePayment(fraudRequestDTO);
//    }
//}
//
//
