package com.wellsfargo.batch2Group2.BankUserManagement.service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.AccountRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.StatementRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.TransactionRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import org.springframework.data.repository.query.Param;

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
	
	@Override
	public List<TransactionDetails> getStatement(StatementRequest sr){
		
		return repo.getStatementfromAccFromToDate(sr.getCustomerId()+"1", sr.getTransactionType() , sr.getFrom(),sr.getTo());
	}
	
	

}
