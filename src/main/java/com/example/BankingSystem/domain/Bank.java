package com.example.BankingSystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private Long acc_no;
    private String name;
    private int balance;

    
    // Constructors

    public Bank() {
        super();
    }

    public Bank(Long id, Long acc_no, String name, int balance) {
        super();
        this.id = id;
        this.acc_no = acc_no;
        this.name = name;
        this.balance = balance;
    }


    // Get and Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(Long acc_no) {
        this.acc_no = acc_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
