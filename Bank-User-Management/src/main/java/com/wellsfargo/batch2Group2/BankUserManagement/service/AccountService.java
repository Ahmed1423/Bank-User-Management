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

//	@Override
//	public String depositAmount(AccountMaster account) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String withdrawAmount(AccountMaster account) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}