package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;

public interface LoanRepository extends JpaRepository<LoanDetails, Long> {

}
