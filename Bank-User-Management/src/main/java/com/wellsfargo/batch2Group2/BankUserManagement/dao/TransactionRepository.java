package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails, String>{

}
