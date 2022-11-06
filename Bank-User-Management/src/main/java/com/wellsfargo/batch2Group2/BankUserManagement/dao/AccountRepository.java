package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;

@Repository
public interface AccountRepository extends JpaRepository<AccountMaster, String>{

}
