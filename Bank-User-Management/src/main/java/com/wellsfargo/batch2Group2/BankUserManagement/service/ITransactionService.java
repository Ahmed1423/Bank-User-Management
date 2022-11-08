package com.wellsfargo.batch2Group2.BankUserManagement.service;

import java.util.List;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.StatementRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionRequest;

public interface ITransactionService {

	public String depositAmount(TransactionRequest details, String accountNumber);
	public String withdrawAmount(TransactionRequest details, String accountNumber);
	String getStatement(StatementRequest sr) throws Exception;
}
