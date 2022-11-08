
package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;

public interface IAccountService {
    public void createAccount(AccountMaster account);
	public String depositAmount(String accountNumber, int amount);
	public String withdrawAmount(String accountNumber, int amount);
}

