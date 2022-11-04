package com.wellsfargo.batch2Group2.BankUserManagement.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_master")
public class CustomerMaster {
	
	@Id
	private Long customer_number;
	
	@Column(name="firstname",nullable = false, length = 30)
    private String firstName;
	@Column(name="lastname",nullable = false, length = 30)
    private String lastName;
	@Column(name="middlename",nullable = false, length = 30)
    private String middleName;
	@Column(name="customer_city",nullable = false, length = 15)
    private String customerCity;
	@Column(name="customer_contact_no",nullable = false, length = 10)
    private String customerContactNo;
	@Column(name="occupation",nullable = false, length = 20)
    private String occupation;
	@Column(name="customer_date_of_birth",nullable = false)
    private Date customerDateOdBirth;
	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL)
	private List<AccountMaster> accountMaster = new ArrayList<>();
	public Long getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(Long customer_number) {
		this.customer_number = customer_number;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerContactNo() {
		return customerContactNo;
	}
	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Date getCustomerDateOdBirth() {
		return customerDateOdBirth;
	}
	public void setCustomerDateOdBirth(Date customerDateOdBirth) {
		this.customerDateOdBirth = customerDateOdBirth;
	}
	public List<AccountMaster> getAccountMaster() {
		return accountMaster;
	}
	public void setAccountMaster(List<AccountMaster> accountMaster) {
		this.accountMaster = accountMaster;
	}

	public CustomerMaster() {
		
	}
}
