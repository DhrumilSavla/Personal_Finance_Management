package com.example.service;

import com.example.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsBySender(String senderAccount);
    BigDecimal getTotalIncomeForAccount(String accountNumber);
    void updateIncomeForTransaction(String senderAccount, String receiverAccount);

}
