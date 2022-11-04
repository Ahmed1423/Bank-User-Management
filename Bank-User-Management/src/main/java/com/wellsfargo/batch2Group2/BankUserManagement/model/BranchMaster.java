package com.wellsfargo.batch2Group2.BankUserManagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "branch_master")
public class BranchMaster {
	@Id
    private Long branch_id;
	
	@Column(name="branch_name",nullable = false, length = 30)
    private String branchName;
	@Column(name="branch_city",nullable = false, length = 30)
    private String branchCity;
	
	 @OneToMany(mappedBy = "branchMaster", cascade = CascadeType.ALL)
	    private List<LoanDetails> loanDetails = new ArrayList<>();
	 @OneToMany(mappedBy = "branchMaster", cascade = CascadeType.ALL)
	    private List<AccountMaster> accountMaster = new ArrayList<>();

}
