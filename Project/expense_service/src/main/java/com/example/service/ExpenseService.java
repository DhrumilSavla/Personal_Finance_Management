package com.example.service;

import com.example.entity.Expense;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {

    public List<Expense> getAllExpenses();
    public Expense getExpenseById(Long id);
    public Expense createExpense(Expense expense);
    public Expense updateExpense(Long id, Expense expenseDetails);
    public void deleteExpense(Long id);

    BigDecimal getTotalExpense(String accountNumber);
}
