package com.wellsfargo.batch2Group2.BankUserManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.StatementRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.service.CustomerService;
import com.wellsfargo.batch2Group2.BankUserManagement.service.TransactionService;

@CrossOrigin(origins="*")
@RestController
public class TransactionController {
	
	@Autowired
	TransactionService ser;
	
	@Autowired
	CustomerService cusSer;
	
	@PostMapping("/makeTransaction")
	public String depositAmount(@RequestBody TransactionRequest details) {
		System.out.println(details.toString());
		String accountNumber = cusSer.getAccountNumber(details.getCustomerNumber()).get(0);
		if(details.getTransactionType().toLowerCase().equals("deposit")) {
			return ser.depositAmount(details, accountNumber);
		} else {
			return ser.withdrawAmount(details, accountNumber);
		}
		
	}

	
	@RequestMapping(value = "/getStatement", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity getStatement(@RequestBody StatementRequest sr) throws Exception {
		return new ResponseEntity(ser.getStatement(sr),HttpStatus.OK);
	}
}
