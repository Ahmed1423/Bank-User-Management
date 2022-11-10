package com.wellsfargo.batch2Group2.BankUserManagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.service.AccountService;
import com.wellsfargo.batch2Group2.BankUserManagement.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	MockMvc mockMvc;
	CustomerMaster customer;
	LoanDetails loanDetails;
	ObjectMapper objMapper;

	@Mock
    CustomerService custService;
	@Mock
    AccountService accService;
	@InjectMocks
	CustomerController customerControllerMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc  = MockMvcBuilders.standaloneSetup(customerControllerMock).build();
		objMapper = new ObjectMapper();
		customer = new CustomerMaster();
		loanDetails = new LoanDetails();
	}
	
	@Test
	public void createAccount() throws Exception {
		mockMvc.perform(post("/register")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(objMapper.writeValueAsString(customer)))
	    .andExpect(status().isOk());
	}
	
	@Test
	public void applyLoan() throws Exception {
		mockMvc.perform(post("/applyLoan")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objMapper.writeValueAsString(loanDetails)))
			    .andExpect(status().isOk());
	}
	
	@Test
	public void viewLoan() throws Exception {
		mockMvc.perform(get("/viewLoan")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("customerId", "12"))
			    .andExpect(status().isOk());
	}
	
}
