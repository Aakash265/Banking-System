package com.example.BankingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  //importing service from springframework

import com.example.BankingSystem.domain.Bank;
import com.example.BankingSystem.repository.BankRepository;

@Service
public class BankService {       
        @Autowired
        private BankRepository repo;

        public List<Bank> listAll() {
            return repo.findAll();
        }

        public void save(Bank acc) {
            repo.save(acc);
        }

        public Bank get(long id) {
            return repo.findById(id).get();
        }

        public void delete(long id) {
            repo.deleteById(id);
        }
}
