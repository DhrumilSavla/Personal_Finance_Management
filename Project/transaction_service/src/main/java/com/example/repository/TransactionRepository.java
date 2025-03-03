package com.example.repository;

import com.example.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{
    List<Transaction> findBySenderAccount(String senderAccount);

    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.senderAccount = :accountNumber OR t.receiverAccount = :accountNumber")
    Optional<BigDecimal> findTotalIncomeByAccount(String accountNumber);

}
