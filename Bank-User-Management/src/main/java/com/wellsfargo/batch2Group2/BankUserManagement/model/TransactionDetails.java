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
    private String transcationType;
	
	@Column(name="transaction_amount",nullable = false, length = 7)
    private int transactionAmount;
	@Column(name="date_of_transaction",nullable = false)
    private Date dateOfTransaction;
	
	 @ManyToOne
	    @JoinColumn(name ="account_number", nullable = false)
	    private AccountMaster accountMaster;

	public String getTransaction_number() {
		return transaction_number;
	}

	public void setTransaction_number(String transaction_number) {
		this.transaction_number = transaction_number;
	}

	public String getMediumOftranscation() {
		return mediumOftranscation;
	}

	public void setMediumOftranscation(String mediumOftranscation) {
		this.mediumOftranscation = mediumOftranscation;
	}

	public String getTranscation_type() {
		return transcationType;
	}

	public void setTranscation_type(String transcation_type) {
		this.transcationType = transcation_type;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public AccountMaster getAccountMaster() {
		return accountMaster;
	}

	public void setAccountMaster(AccountMaster accountMaster) {
		this.accountMaster = accountMaster;
	}
	
	public TransactionDetails() {
		
	}
}
