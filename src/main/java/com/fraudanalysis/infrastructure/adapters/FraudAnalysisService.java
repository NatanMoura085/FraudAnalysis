package com.fraudanalysis.infrastructure.adapters;

import com.fraudanalysis.application.dtos.FraudRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class FraudAnalysisService {
    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();

    public void analyzePayment(FraudRequestDTO fraudRequestDTO) {
        String prompt = buildPrompt(fraudRequestDTO);

        Map<String, Object> request = Map.of(
                "model", "deepseek-r1:7b",
                "prompt", prompt,
                "stream", false
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:11434/api/generate",
                entity,
                String.class
        );

        String result = response.getBody();
        System.out.println("Análise de Fraude: " + result);

        // Aqui você poderia transformar esse result num DTO e enviar pra outra API ou armazenar
    }

    private String buildPrompt(FraudRequestDTO fraudRequestDTO) {
        return String.format("Analise se essa transação é fraude:\nValor: %.2f\nMétodo: %s\nData: %s\nPedido: %d\nStatus: ",
                fraudRequestDTO.amount(), fraudRequestDTO.paymentMethod(), fraudRequestDTO.paymentDate(), fraudRequestDTO.orderId());
    }
}
