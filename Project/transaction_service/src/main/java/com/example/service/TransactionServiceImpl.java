package com.example.service;

import com.example.entity.Transaction;
import com.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl  implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        updateIncomeForTransaction(transaction.getSenderAccount(), transaction.getReceiverAccount());
        return savedTransaction;
    }
    private final String SAVINGS_SERVICE_URL = "http://savings-service/savings/update-balance/{accountNumber}";

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsBySender(String senderAccount) {
        return transactionRepository.findBySenderAccount(senderAccount);
    }
    public BigDecimal getTotalIncomeForAccount(String accountNumber) {
        return transactionRepository.findTotalIncomeByAccount(accountNumber).orElse(BigDecimal.ZERO);
    }
    public void updateIncomeForTransaction(String senderAccount, String receiverAccount) {
        BigDecimal senderIncome = getTotalIncomeForAccount(senderAccount);
        BigDecimal receiverIncome = getTotalIncomeForAccount(receiverAccount);

        // Call Savings Service to update both sender & receiver balance
        restTemplate.put(SAVINGS_SERVICE_URL + "?accountNumber=" + senderAccount + "&amount=" + senderIncome + "&isExpense=true", null);
        restTemplate.put(SAVINGS_SERVICE_URL + "?accountNumber=" + receiverAccount + "&amount=" + receiverIncome + "&isExpense=false", null);
    }

}
