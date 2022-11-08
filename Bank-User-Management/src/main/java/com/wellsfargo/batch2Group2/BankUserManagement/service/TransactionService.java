package com.wellsfargo.batch2Group2.BankUserManagement.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.AccountRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.StatementRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.TransactionRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionRequest;

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
	public String depositAmount(TransactionRequest details, String accountNumber) {
		
		TransactionDetails t = new TransactionDetails();
		AccountMaster acc = acrepo.getReferenceById(accountNumber);
		t.setAccountMaster(acc);
		System.out.println(t.getAccountMaster());
		String accNumber = accountNumber;
		int amount = details.getTransactionAmount();
		serv.depositAmount(accNumber, amount);
		t.setDateOfTransaction(LocalDate.now());
		t.setMediumOftransaction("Rupees");
		t.setTransactionAmount(details.getTransactionAmount());
		t.setTransactionType(details.getTransactionType());
		repo.save(t);
		return "successful";
	}

	@Override
	public String withdrawAmount(TransactionRequest details, String accountNumber) {
		
		TransactionDetails t = new TransactionDetails();

		AccountMaster acc = acrepo.getReferenceById(accountNumber);
		t.setAccountMaster(acc);
		String accNumber = accountNumber;
		int amount = details.getTransactionAmount();
		
		if(serv.withdrawAmount(accNumber, amount).equals("Withdrawed Successfully")) {
			t.setDateOfTransaction(LocalDate.now());
			t.setMediumOftransaction("Rs");
			t.setTransactionAmount(details.getTransactionAmount());
			t.setTransactionType(details.getTransactionType());
			
			repo.save(t);
			return "Successful";
		} else {
			return "No Sufficient Balance";
		}
	}
	
	@Override
	public String getStatement(StatementRequest sr) throws Exception{
		List<TransactionDetails> t = 		repo.getStatementfromAccFromToDate(sr.getCustomerId()+"1", sr.getTransactionType() , sr.getFrom(),sr.getTo());
		//System.out.println(ServiceUtils.convertJava2JSON(t));    
		return ServiceUtils.convertJava2JSON(t);//repo.getStatementfromAccFromToDate(sr.getCustomerId()+"1", sr.getTransactionType() , sr.getFrom(),sr.getTo());
	}
	
	

}
