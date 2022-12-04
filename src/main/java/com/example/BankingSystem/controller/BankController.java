package com.example.BankingSystem.controller;

import java.util.List;

import javax.print.event.PrintJobListener;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.BankingSystem.domain.Bank;
import com.example.BankingSystem.service.BankService;

@Controller
public class BankController {
    @Autowired
    private BankService service;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
 
    @GetMapping("/dash")
    public String viewHomePage(Model model) {
        List<Bank> listbank = service.listAll();
        model.addAttribute("listbank", listbank);
        System.out.println("/Get");
        return "index";
    }

    // @GetMapping("/search/{acc_no}")
    // public String search(@PathVariable(name = "acc_no") int acc) {
    //     // System.out.println(acc);
    //     // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "");
    //     // if(conn != null) {
    //     //     System.out.println("Conn success");
    //     // }
    //     // else {
    //     //     System.out.println("Lost Conn");
    //     // }
    //     // Statement stmt = conn.createStatement();
    //     // String query[] = {"SELECT * FROM bank WHERE acc_no = acc"};
        
    //     // for (String str : query) {
    //     //     ResultSet res = stmt.executeQuery(str);

    //     //     while (res.next()) {
    //     //         String name = res.getString(acc);
    //     //         System.out.println(name);
    //     //     }
    //     // }
    //     return "search";
    // }
 
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("bank", new Bank());
        return "new";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBank(@ModelAttribute("bank") Bank acc) {
        service.save(acc);
        return "redirect:/dash";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBankPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Bank acc = service.get(id);
        mav.addObject("bank", acc);
        return mav; 
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteBank(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/dash";
    }
}
