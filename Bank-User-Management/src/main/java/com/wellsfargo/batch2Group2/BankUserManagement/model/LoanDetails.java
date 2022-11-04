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

	    @Column(name="branch_city",nullable = false, length = 100)
	    private String branchCity;

	    //@ManyToOne(mappedBy = "account", cascade = CascadeType.ALL)
	    @ManyToOne
	    @JoinColumn(name ="customer_number", nullable = false)
	    private CustomerMaster customerMaster;
	    //private List<AccountSettings> accountSettings = new ArrayList<>();
	    @ManyToOne
	    @JoinColumn(name ="branch_id", nullable = false)
	    private BranchMaster branchMaster;
	    // getters and setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBranchCity() {
			return branchCity;
		}
		public void setBranchCity(String branchCity) {
			this.branchCity = branchCity;
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
}
