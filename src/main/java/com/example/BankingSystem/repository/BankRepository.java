package com.example.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingSystem.domain.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
    
}
