package com.wellsfargo.batch2Group2.BankUserManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.wellsfargo.batch2Group2.BankUserManagement.model"})
public class BankUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserManagementApplication.class, args);
	}

}
