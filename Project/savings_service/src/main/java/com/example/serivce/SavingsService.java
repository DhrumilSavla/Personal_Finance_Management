package com.example.serivce;

import com.example.entity.Savings;

import java.math.BigDecimal;
import java.util.Optional;

public interface SavingsService {
    Savings createSavings(Savings savings);
    Optional<Savings> getSavingsByAccountNumber(String accountNumber);
    BigDecimal updateSavingsBalance(String accountNumber);
    BigDecimal getTotalSavings(String accountNumber);
}
