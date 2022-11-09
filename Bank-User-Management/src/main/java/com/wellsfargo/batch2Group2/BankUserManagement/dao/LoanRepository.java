package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellsfargo.batch2Group2.BankUserManagement.model.LoanDetails;
import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;

public interface LoanRepository extends JpaRepository<LoanDetails, Long> {
	@Query(value = "SELECT * FROM loan_details l WHERE l.customer_number=:cus_num", nativeQuery = true)
	List<LoanDetails> getloandetails(@Param("cus_num") String cusnum);

}
