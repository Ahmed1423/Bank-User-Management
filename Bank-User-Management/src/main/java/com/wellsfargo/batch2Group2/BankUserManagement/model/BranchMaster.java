package com.wellsfargo.batch2Group2.BankUserManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "branch_master")
public class BranchMaster {
	@Id
    private String branch_id;
	
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	public List<LoanDetails> getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(List<LoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}
	public List<AccountMaster> getAccountMaster() {
		return accountMaster;
	}
	public void setAccountMaster(List<AccountMaster> accountMaster) {
		this.accountMaster = accountMaster;
	}
	@Column(name="branch_name",nullable = false, length = 30)
    private String branchName;
	@Column(name="branch_city",nullable = false, length = 30)
    private String branchCity;
	
	 @OneToMany(mappedBy = "branchMaster", cascade = CascadeType.ALL)
//	 @JsonManagedReference
	 @JsonIgnore
	    private List<LoanDetails> loanDetails = new ArrayList<>();
	 @OneToMany(mappedBy = "branchMaster", cascade = CascadeType.ALL)
//	 @JsonManagedReference
	 @JsonIgnore
	    private List<AccountMaster> accountMaster = new ArrayList<>();

	 public BranchMaster() {
		 
	 }
}
