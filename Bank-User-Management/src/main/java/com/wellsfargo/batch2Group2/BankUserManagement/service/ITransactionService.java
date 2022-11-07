package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;

public interface ITransactionService {

	public String depositAmount(TransactionDetails details, String accountNumber);
	public String withdrawAmount(TransactionDetails details, String accountNumber);
}
