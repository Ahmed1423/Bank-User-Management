package com.wellsfargo.batch2Group2.BankUserManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.AccountRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.TransactionRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	TransactionRepository repo;
	@Autowired
	AccountService serv;
	@Autowired
	AccountRepository acrepo;
	
	@Override
	public String depositAmount(TransactionDetails details, String accountNumber) {
		
		AccountMaster acc = acrepo.getReferenceById(accountNumber);
		details.setAccountMaster(acc);
		System.out.println(details.getAccountMaster());
		String accNumber = accountNumber;
		int amount = details.getTransactionAmount();
		
		serv.depositAmount(accNumber, amount);
		repo.save(details);
		return "successful";
	}

	@Override
	public String withdrawAmount(TransactionDetails details, String accountNumber) {
		
		AccountMaster acc = acrepo.getReferenceById(accountNumber);
		details.setAccountMaster(acc);
		String accNumber = accountNumber;
		int amount = details.getTransactionAmount();
		
		if(serv.withdrawAmount(accNumber, amount)) {
			repo.save(details);
			return "Successful";
		} else {
			return "No Sufficient Balance";
		}
	}

}
