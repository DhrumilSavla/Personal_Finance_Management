package com.example.service;

import com.example.entity.Budget;
import com.example.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;
    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget updateBudget(Long id, Budget budget) {
        Budget existingBudget = getBudgetById(id);
        existingBudget.setCategory(budget.getCategory());
        existingBudget.setAmount(budget.getAmount());
        return budgetRepository.save(existingBudget);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
