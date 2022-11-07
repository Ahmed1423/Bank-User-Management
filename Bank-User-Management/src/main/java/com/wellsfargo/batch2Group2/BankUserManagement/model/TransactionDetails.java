package com.wellsfargo.batch2Group2.BankUserManagement.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String transactionNumber;
	
	@Column(name="medium_of_transaction",nullable = false, length = 30)
    private String mediumOftransaction;
	
	@Column(name="transaction_type",nullable = false, length = 30)
    private String transactionType;
	
	@Column(name="transaction_amount",nullable = false, length = 7)
    private int transactionAmount;
	
	@Column(name="date_of_transaction",nullable = false)
    private LocalDate dateOfTransaction;
	
	@ManyToOne
	@JoinColumn(name ="account_number", nullable = false)
	private AccountMaster accountMaster;

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transaction_number) {
		this.transactionNumber = transaction_number;
	}

	public String getMediumOftransaction() {
		return mediumOftransaction;
	}

	public void setMediumOftransaction(String mediumOftransaction) {
		this.mediumOftransaction = mediumOftransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
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
