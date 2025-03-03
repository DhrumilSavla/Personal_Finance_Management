package com.example.controller;

import com.example.entity.Transaction;
import com.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private  TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/sender/{senderAccount}")
    public List<Transaction> getTransactionsBySender(@PathVariable String senderAccount) {
        return transactionService.getTransactionsBySender(senderAccount);
    }
    @GetMapping("/total-income/{accountNumber}")
    public ResponseEntity<BigDecimal> getTotalIncomeForAccount(@PathVariable String accountNumber) {
        BigDecimal totalIncome = transactionService.getTotalIncomeForAccount(accountNumber);
        return ResponseEntity.ok(totalIncome);
    }
    @PostMapping("/update-transaction-income/{senderAccount}/{receiverAccount}")
    public ResponseEntity<String> updateTransactionIncome(
            @PathVariable String senderAccount, @PathVariable String receiverAccount) {
        transactionService.updateIncomeForTransaction(senderAccount, receiverAccount);
        return ResponseEntity.ok("Transaction income updated for sender and receiver.");
    }
}
