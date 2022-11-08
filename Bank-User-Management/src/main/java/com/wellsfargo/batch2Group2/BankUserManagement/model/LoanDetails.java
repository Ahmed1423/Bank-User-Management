package com.wellsfargo.batch2Group2.BankUserManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_details")
public class LoanDetails {
	    @Id
	    @GeneratedValue
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name ="customer_number", nullable = false)
	    private CustomerMaster customerMaster;

	    @ManyToOne
	    @JoinColumn(name ="branch_id", nullable = false)
	    private BranchMaster branchMaster;
	    
	    @Column(name="loan_amount",nullable = false, length = 7)
	    private int loanAmount;
	    
	    @Column(name="C_ID",nullable = false)
	    private String customerNumber;
	    
	    @Column(name="B_ID",nullable = false, length = 7)
	    private String branchId;
	    
	    // getters and setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public int getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(int loanAmount) {
			this.loanAmount = loanAmount;
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
		public LoanDetails() {
			
		}
		public String getCustomerNumber() {
			return customerNumber;
		}
		public void setCustomerNumber(String customerNumber) {
			this.customerNumber = customerNumber;
		}
		public String getBranchId() {
			return branchId;
		}
		public void setBranchId(String branchId) {
			this.branchId = branchId;
		}
		@Override
		public String toString() {
			return "LoanDetails [id=" + id + ", customerMaster=" + customerMaster + ", branchMaster=" + branchMaster
					+ ", loanAmount=" + loanAmount + ", customerNumber=" + customerNumber + ", branchId=" + branchId
					+ "]";
		}
		
		
}
