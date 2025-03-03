package com.example.controller;

import com.example.entity.Savings;
import com.example.serivce.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    private SavingsService savingsService;

    @GetMapping("/total-savings/{accountNumber}")
    public ResponseEntity<BigDecimal> getTotalSavings(@PathVariable String accountNumber) {
        BigDecimal updatedBalance = savingsService.getTotalSavings(accountNumber);
        return ResponseEntity.ok(updatedBalance);
    }
}
