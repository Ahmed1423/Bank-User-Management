package com.wellsfargo.batch2Group2.BankUserManagement.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch2Group2.BankUserManagement.dao.AccountRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.BranchRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.CustomerRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.LoanRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;
import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository custRepo;
    @Autowired
    AccountRepository accRepo;
    @Autowired
    BranchRepository br;
    @Autowired
    AccountService accService;
    @Autowired
    LoanRepository loanRepo;

    @Override
    public String registerAccount(CustomerMaster customer){
        // TODO Auto-generated method stub
        if(userAccountExists(customer.getCustomerNumber())) {
            return "Customer Already Exists";
        }

        custRepo.save(customer);
        AccountMaster ac = new AccountMaster();
        ac.setAccountOpeningDate(LocalDate.of(2022, Month.NOVEMBER, 05));
        ac.setAccountStatus("OPEN");
        ac.setCustomerMaster(customer);
        ac.setAccountType("Savings");
        ac.setBalance(0);
        if(customer.getCustomerCity().equals("Hyderabad")) {
            ac.setAccountNumber(customer.getCustomerNumber().toString() + "1");
            ac.setBranchMaster(br.getReferenceById(1L));
        } else if(customer.getCustomerCity().equals("Bangalore")) {
            ac.setAccountNumber(customer.getCustomerNumber().toString() + "2");
            ac.setBranchMaster(br.getReferenceById(2L));
        } else {
            ac.setAccountNumber(customer.getCustomerNumber().toString() + "3");
            ac.setBranchMaster(br.getReferenceById(3L));
        }
        accService.createAccount(ac);
        return "Successful";
    }

    public Boolean userAccountExists(String customerId) {
        // TODO Auto-generated method stub
        return custRepo.existsById(customerId);
    }

    @Override
    public String isLoginDetailsCorrect(String customerId, String password) {
        // TODO Auto-generated method stub
        Optional <CustomerMaster> customer = custRepo.findById(customerId);
//		
        if(customer.isEmpty()) return "Account Does not Exist";
        else {
            password = password.substring(1, password.length() - 1);
            CustomerMaster cust = custRepo.getReferenceById(customerId);
            if(cust.getCustomerPassword().equals(password)) {
                return "Login Details Correct";
            } else {
                System.out.println(cust.getCustomerPassword() + " " + password);
                return "Login Details incorrect";
            }
        }
    }
    
    @Override
    public String applyLoan(LoanDetails loanDetails) {
    	if(!userAccountExists(loanDetails.getCustomerMaster().getCustomerNumber())) {
            return "INVALID CUSTOMER ID";
        }
        
    	loanRepo.save(loanDetails);
    	return "Successful";
    }
}