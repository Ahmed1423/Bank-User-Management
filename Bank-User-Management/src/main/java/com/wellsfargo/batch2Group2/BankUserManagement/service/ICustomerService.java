package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;

public interface ICustomerService {
    public String registerAccount(CustomerMaster customer);
    public Boolean userAccountExists(Long customerId);
    public String applyLoan(LoanDetails loanDetails);
//    public String isLoginDetailsCorrect(Long customerId, String password);
}


