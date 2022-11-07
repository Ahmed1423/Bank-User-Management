package com.wellsfargo.batch2Group2.BankUserManagement.dao;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellsfargo.batch2Group2.BankUserManagement.model.TransactionDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails, String>{
	@Query(value = "SELECT * FROM transaction_details t WHERE t.account_number=:acc_num AND t.transaction_type=:type AND t.date_of_transaction >= :from AND t.date_of_transaction<= :to", nativeQuery = true)
	List<TransactionDetails> getStatementfromAccFromToDate(@Param("acc_num") String accnum,@Param("type") String type ,@Param("from") Date from,@Param("to") Date to);
}
