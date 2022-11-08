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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_master")
public class CustomerMaster {

	@Id
	@Column(name="customer_number")
	private String customerNumber;

	@Column(name="firstname",nullable = false, length = 30)
	private String firstName;
	@Column(name="lastname",nullable = false, length = 30)
	private String lastName;
	@Column(name="customer_city",nullable = false, length = 15)
	private String customerCity;
	@Column(name="customer_contact_no",nullable = false, length = 10)
	private String customerContactNo;
	@Column(name="occupation",nullable = false, length = 20)
	private String occupation;
	@Column(name="customer_date_of_birth",nullable = false)
	private Date customerDateOdBirth;
	private String customerPassword;


	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@OneToMany(mappedBy = "customerMaster", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<AccountMaster> accountMaster = new ArrayList<>();

	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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
	public CustomerMaster(String customerNumber, String firstName, String lastName, String customerCity,
						  String customerContactNo, String occupation, Date customerDateOdBirth, String customerPassword) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerCity = customerCity;
		this.customerContactNo = customerContactNo;
		this.occupation = occupation;
		this.customerDateOdBirth = customerDateOdBirth;
		this.customerPassword = customerPassword;
	}

}
