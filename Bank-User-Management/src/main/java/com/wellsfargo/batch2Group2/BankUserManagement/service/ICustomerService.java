package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.Exception.ResourceNotFoundException;

//import org.springframework.http.ResponseEntity;

//import com.wellsfargo.batch2Group2.BankUserManagement.Exception.ResourceNotFoundException;
import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;

public interface ICustomerService {
    public String registerAccount(CustomerMaster customer);
    public Boolean userAccountExists(String customerId);
    public String applyLoan(LoanDetails loanDetails);
    public String isLoginDetailsCorrect(String customerId, String password);
	String viewLoan(String customerId) throws Exception;
}


