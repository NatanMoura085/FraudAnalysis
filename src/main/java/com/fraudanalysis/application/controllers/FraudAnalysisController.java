package com.fraudanalysis.application.controllers;

import com.fraudanalysis.application.dtos.FraudRequestDTO;
import com.fraudanalysis.infrastructure.adapters.FraudAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud")
public class FraudAnalysisController {
    private final FraudAnalysisService fraudAnalysisService;

    @Autowired
    public FraudAnalysisController(FraudAnalysisService fraudAnalysisService) {
        this.fraudAnalysisService = fraudAnalysisService;
    }

    @PostMapping("/analyze")
    public String analyzePayment(@RequestBody FraudRequestDTO fraudRequestDTO) {
        fraudAnalysisService.analyzePayment(fraudRequestDTO);
        return "ANALYZE COMPLETED";
    }
}
