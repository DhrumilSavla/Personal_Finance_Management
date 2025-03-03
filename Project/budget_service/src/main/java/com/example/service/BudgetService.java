package com.example.service;

import com.example.entity.Budget;

import java.util.List;

public interface BudgetService {
    Budget createBudget(Budget budget);
    Budget getBudgetById(Long id);
    List<Budget> getAllBudgets();
    Budget updateBudget(Long id, Budget budget);
    void deleteBudget(Long id);
}
