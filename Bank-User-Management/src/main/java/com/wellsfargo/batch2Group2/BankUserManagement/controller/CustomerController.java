package com.wellsfargo.batch2Group2.BankUserManagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
//import com.wellsfargo.batch2Group2.BankUserManagement.service.AccountService;
import com.wellsfargo.batch2Group2.BankUserManagement.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    CustomerService custService;

    @PostMapping("/register")
    public String createAccount(@RequestBody CustomerMaster customer) {
        return custService.registerAccount(customer);
    }
}
