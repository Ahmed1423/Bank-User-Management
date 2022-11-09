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
import com.wellsfargo.batch2Group2.BankUserManagement.dao.CustomerRepository;
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
	@Autowired
	CustomerService cserv;
	
	
	@Override
	public String depositAmount(TransactionRequest details, String accountNumber) {
		
		TransactionDetails t = new TransactionDetails();
		AccountMaster acc = acrepo.getReferenceById(accountNumber);
		t.setAccountMaster(acc);
		System.out.println(t.getAccountMaster());
		String accNumber = accountNumber;
		int amount = details.getTransactionAmount();
		String stmt = serv.depositAmount(accNumber, amount);
		t.setDateOfTransaction(LocalDate.now());
		t.setMediumOftransaction("Rupees");
		t.setTransactionAmount(details.getTransactionAmount());
		t.setTransactionType(details.getTransactionType());
		repo.save(t);
		return stmt;
	}

	@Override
	public String withdrawAmount(TransactionRequest details, String accountNumber) {
		
		TransactionDetails t = new TransactionDetails();

		AccountMaster acc = acrepo.getReferenceById(accountNumber);
		t.setAccountMaster(acc);
		String accNumber = accountNumber;
		int amount = details.getTransactionAmount();
		
		String stmt = serv.withdrawAmount(accNumber, amount);
		
		if(stmt.startsWith("Withdrawed Successfully")) {
			t.setDateOfTransaction(LocalDate.now());
			t.setMediumOftransaction("Rs");
			t.setTransactionAmount(details.getTransactionAmount());
			t.setTransactionType(details.getTransactionType());
			
			repo.save(t);
			return stmt;
		} else {
			return stmt;
		}
	}
	
	@Override
	public String getStatement(StatementRequest sr) throws Exception{
		List<TransactionDetails> t = 		repo.getStatementfromAccFromToDate(cserv.getAccountNumber(sr.getCustomerId()).get(0), sr.getTransactionType() , sr.getFrom(),sr.getTo());
		System.out.println(sr.getCustomerId());
		System.out.println(ServiceUtils.convertJava2JSON(t));    
		return ServiceUtils.convertJava2JSON(t);//repo.getStatementfromAccFromToDate(sr.getCustomerId()+"1", sr.getTransactionType() , sr.getFrom(),sr.getTo());
	}
	
	

}
