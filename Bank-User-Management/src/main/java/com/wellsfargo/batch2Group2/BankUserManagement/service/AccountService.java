package com.wellsfargo.batch2Group2.BankUserManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.AccountRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public void createAccount(AccountMaster account) {
        // TODO Auto-generated method stub
        repo.save(account);
    }

	@Override
	public void depositAmount(String accountNumber, int amount) {
		// TODO Auto-generated method stub
		AccountMaster account = repo.getReferenceById(accountNumber);
		account.setBalance(account.getBalance() + amount);
		repo.save(account);
	}

	@Override
	public boolean withdrawAmount(String accountNumber, int amount) {
		// TODO Auto-generated method stub
		AccountMaster account = repo.getReferenceById(accountNumber);
		if(amount > account.getBalance()) {
			return false;
		}
		account.setBalance(account.getBalance() - amount);
		repo.save(account);
		return true;
	}

}