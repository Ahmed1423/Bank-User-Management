package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch2Group2.BankUserManagement.model.AccountMaster;

@Repository
public interface AccountRepository extends JpaRepository<AccountMaster, String>{

	@Query(value = "SELECT account_number FROM account_master a WHERE a.customer_number=:cus_num", nativeQuery = true)
	List<String> getAccountNumbersFromCusId(@Param("cus_num") String cusNum);

}
