package com.wellsfargo.batch2Group2.BankUserManagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {
	
	@Id
    private String transaction_number;
	
	@Column(name="medium_of_transaction",nullable = false, length = 30)
    private String mediumOftranscation;
	
	@Column(name="transaction_type",nullable = false, length = 30)
    private String transcation_type;
	
	@Column(name="transaction_amount",nullable = false, length = 7)
    private int transactionAmount;
	@Column(name="date_of_transaction",nullable = false)
    private Date dateOfTransaction;
	
	 @ManyToOne
	    @JoinColumn(name ="account_number", nullable = false)
	    private AccountMaster accountMaster;
	

}
