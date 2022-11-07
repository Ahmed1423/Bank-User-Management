
package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;

public interface IAccountService {
    public void createAccount(AccountMaster account);
	public void depositAmount(String accountNumber, int amount);
	public boolean withdrawAmount(String accountNumber, int amount);
}

