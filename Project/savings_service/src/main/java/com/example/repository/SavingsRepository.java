package com.example.repository;

import com.example.entity.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

import  java.util.Optional;
public interface SavingsRepository extends JpaRepository<Savings,Long> {
    Optional<Savings> findByAccountNumber(String accountNumber);
}
