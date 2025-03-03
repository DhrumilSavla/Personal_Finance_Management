package com.example.service;

import com.example.entity.Expense;
import com.example.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository repository;

    public List<Expense> getAllExpenses(){
        return repository.findAll();
    }
    public Expense getExpenseById(Long id){
        return repository.findById(id).orElse(null);
    }
    public Expense createExpense(Expense expense){
        return repository.save(expense);
    }
    public Expense updateExpense(Long id, Expense expenseDetails){
        Expense expense = repository.findById(id).orElse(null);
        if (expense != null) {
            expense.setDescription(expenseDetails.getDescription());
            expense.setAmount(expenseDetails.getAmount());
            return repository.save(expense);
        }
        return null;
    }
    public void deleteExpense(Long id){
        repository.deleteById(id);
    }
    public BigDecimal getTotalExpense(String accountNumber){
        return repository.findTotalExpenseByAccount(accountNumber).orElse(BigDecimal.ZERO);

    }
}
