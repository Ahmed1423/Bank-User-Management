package com.wellsfargo.batch2Group2.BankUserManagement.service;

import java.util.List;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.StatementRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;

public interface ITransactionService {

	public String depositAmount(TransactionDetails details, String accountNumber);
	public String withdrawAmount(TransactionDetails details, String accountNumber);
	List<TransactionDetails> getStatement(StatementRequest sr);
}
