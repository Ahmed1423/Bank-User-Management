package com.wellsfargo.batch2Group2.BankUserManagement.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account_master")
public class AccountMaster {

	public AccountMaster(String accountNumber, String accountType, String accountStatus,
						 LocalDate accountOpeningDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountOpeningDate = accountOpeningDate;
	}

	@Id
	@Column(name="account_number")
	private String accountNumber;

	@Column(name="account_type",nullable = false, length = 30)
	private String accountType;
	@Column(name="account_status",nullable = false, length = 30)
	private String accountStatus;
	
	@Column(name="account_balance",nullable = false, length = 7)
	private int accountBalance;

	@ManyToOne
	@JoinColumn(name ="customer_number", nullable = false)
	private CustomerMaster customerMaster;
	@ManyToOne
	@JoinColumn(name ="branch_id", nullable = false)
	private BranchMaster branchMaster;
	@Column(name="account_opening_date",nullable = false)
	private LocalDate accountOpeningDate;

	@OneToMany(mappedBy = "accountMaster", cascade = CascadeType.ALL)
	private List<TransactionDetails> transactionDetails = new ArrayList<>();

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public CustomerMaster getCustomerMaster() {
		return customerMaster;
	}

	public void setCustomerMaster(CustomerMaster customerMaster) {
		this.customerMaster = customerMaster;
	}

	public BranchMaster getBranchMaster() {
		return branchMaster;
	}

	public void setBranchMaster(BranchMaster branchMaster) {
		this.branchMaster = branchMaster;
	}

	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDate localDate) {
		this.accountOpeningDate = localDate;
	}

	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public AccountMaster() {

	}

}
