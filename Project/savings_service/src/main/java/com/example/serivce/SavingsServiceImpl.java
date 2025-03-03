package com.example.serivce;

import com.example.entity.Savings;
import com.example.repository.SavingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SavingsServiceImpl implements SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String TRANSACTION_SERVICE_URL = "http://localhost:8083/api/transactions/total-income/{accountNumber}";
    private final String EXPENSE_SERVICE_URL = "http://localhost:8082/api/expenses/total-expense/{accountNumber}";

    @Override
    public Savings createSavings(Savings savings) {
        return savingsRepository.save(savings);
    }

    @Override
    public Optional<Savings> getSavingsByAccountNumber(String accountNumber) {
        return savingsRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public BigDecimal updateSavingsBalance(String accountNumber) {
        Savings savings = savingsRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Savings account not found"));

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;

        // Fetch total income
        try {
            totalIncome = restTemplate.getForObject(TRANSACTION_SERVICE_URL, BigDecimal.class, accountNumber);
        } catch (Exception e) {
            System.out.println("⚠️ Warning: Transaction Service is unavailable. Using default value.");
        }

        // Fetch total expense
        try {
            totalExpense = restTemplate.getForObject(EXPENSE_SERVICE_URL, BigDecimal.class, accountNumber);
        } catch (Exception e) {
            System.out.println("⚠️ Warning: Expense Service is unavailable. Using default value.");
        }

        // Handle null values
        if (totalIncome == null) totalIncome = BigDecimal.ZERO;
        if (totalExpense == null) totalExpense = BigDecimal.ZERO;

        // Calculate new balance
        BigDecimal updatedBalance = savings.getBalance().add(totalIncome).subtract(totalExpense);
        savings.setBalance(updatedBalance);
        savingsRepository.save(savings);

        return updatedBalance;
    }

    @Override
    public BigDecimal getTotalSavings(String accountNumber) {
        return updateSavingsBalance(accountNumber);
    }

}
