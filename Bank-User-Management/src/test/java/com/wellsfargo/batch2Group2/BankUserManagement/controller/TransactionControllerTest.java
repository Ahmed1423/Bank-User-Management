package com.wellsfargo.batch2Group2.BankUserManagement.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.AccountRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.StatementRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionRequest;
import com.wellsfargo.batch2Group2.BankUserManagement.service.AccountService;
import com.wellsfargo.batch2Group2.BankUserManagement.service.CustomerService;
import com.wellsfargo.batch2Group2.BankUserManagement.service.TransactionService;

import antlr.collections.List;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
	
	MockMvc mockMvc;
	ObjectMapper objMapper;
		
	@Mock
	TransactionService ser;
	
	@Mock
	CustomerService cusSer;
	
	@Mock
	AccountRepository accRepo;
	
	@Mock
	TransactionRequest trequest;
	
	
	@InjectMocks
	TransactionController transactionControllerMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc  = MockMvcBuilders.standaloneSetup(transactionControllerMock).build();
		objMapper = new ObjectMapper();
	}
	
	@Test
	public void depositAmount() throws Exception {
		ArrayList<String> details = new ArrayList<String>();
		details.add("1234");
		//Mockito.when(trequest.getCustomerNumber()).thenReturn("1234");
		Mockito.when(accRepo.getAccountNumbersFromCusId(Mockito.anyString())).thenReturn((java.util.List<String>) details);
		
		TransactionRequest request = new TransactionRequest();
		request.setCustomerNumber("1234");
		mockMvc.perform(post("/makeTransaction")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(objMapper.writeValueAsString(request)))
	    .andExpect(status().isOk());
	}
	
	@Test
	public void getStatement() throws Exception {
		
		StatementRequest sr = new StatementRequest();
		//request.setCustomerNumber("1234");
		mockMvc.perform(post("/getStatement")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(objMapper.writeValueAsString(sr)))
	    .andExpect(status().isOk());
	}

}
