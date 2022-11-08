package com.wellsfargo.batch2Group2.BankUserManagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.service.AccountService;
import com.wellsfargo.batch2Group2.BankUserManagement.service.CustomerService;

@RestController
@CrossOrigin(origins="*")
public class CustomerController {

    @Autowired
    CustomerService custService;
    @Autowired
    AccountService accService;

    @PostMapping("/register")
    public String createAccount(@RequestBody CustomerMaster customer){
        return custService.registerAccount(customer);
    }

    @PostMapping("/login")
    public String loginAccount(@RequestBody String details) {

        String id = details.substring(1, details.length() - 1).split(",")[0].split(":")[1].trim();
        String password = details.substring(1, details.length() - 1).split(",")[1].split(":")[1];

        password = password.substring(1, password.length() - 2).trim();
        return custService.isLoginDetailsCorrect(id, password);
    }
    
    @PostMapping("/applyLoan")
    public String applyLoan(@RequestBody LoanDetails loanDetails){
        return custService.applyLoan(loanDetails);
    }
}

