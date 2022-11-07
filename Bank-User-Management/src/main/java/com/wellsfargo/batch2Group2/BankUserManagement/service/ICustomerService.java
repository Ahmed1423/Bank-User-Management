package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.Exception.ResourceNotFoundException;

//import org.springframework.http.ResponseEntity;

//import com.wellsfargo.batch2Group2.BankUserManagement.Exception.ResourceNotFoundException;
import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;

public interface ICustomerService {
    public String registerAccount(CustomerMaster customer);
    public String isLoginDetailsCorrect(Long customerId, String password) throws ResourceNotFoundException;
}


