package com.wellsfargo.batch2Group2.BankUserManagement.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wellsfargo.batch2Group2.BankUserManagement.dao.CustomerRepository;
import com.wellsfargo.batch2Group2.BankUserManagement.model.CustomerMaster;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository custRepo;

    @Override
    public String registerAccount(CustomerMaster customer) {
        // TODO Auto-generated method stub
        if(userAccountExists(customer.getCustomerNumber())) {
            return "Customer Already Exists";
        }

        custRepo.save(customer);

        return "Successful";
    }

    @Override
    public Boolean userAccountExists(Long customerId) {
        // TODO Auto-generated method stub
        Optional <CustomerMaster> customer = custRepo.findById(customerId);
        if(customer.isEmpty()) {
            return false;
        }
        return true;
    }

}

