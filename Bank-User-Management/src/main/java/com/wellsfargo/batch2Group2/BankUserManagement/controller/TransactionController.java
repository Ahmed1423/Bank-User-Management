package com.wellsfargo.batch2Group2.BankUserManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService ser;
	
	@PostMapping("/{accountNumber}/performTransaction")
	public String depositAmount(@RequestBody TransactionDetails details, @PathVariable("accountNumber") String accountNumber) {
		if(details.getTransactionType().equals("deposit")) {
			return ser.depositAmount(details, accountNumber);
		} else {
			return ser.withdrawAmount(details, accountNumber);
		}
		
	}
}
