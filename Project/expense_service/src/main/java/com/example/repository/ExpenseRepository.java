package com.example.repository;

import com.example.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.accountNumber = :accountNumber")
    Optional<BigDecimal> findTotalExpenseByAccount(String accountNumber);

}
