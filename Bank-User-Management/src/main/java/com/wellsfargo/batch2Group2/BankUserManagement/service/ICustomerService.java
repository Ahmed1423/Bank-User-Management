package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;

public interface ICustomerService {
    public String registerAccount(CustomerMaster customer);
    public Boolean userAccountExists(Long customerId);
    public String isLoginDetailsCorrect(Long customerId, String password);
}


