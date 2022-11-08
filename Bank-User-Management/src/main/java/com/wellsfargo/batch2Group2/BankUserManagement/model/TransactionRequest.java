package com.wellsfargo.batch2Group2.BankUserManagement.model;

public class TransactionRequest {
	
	private String customerNumber;
    private int transactionAmount;
    private String transactionType;
    
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "TransactionRequest [customerNumber=" + customerNumber + ", transactionAmount=" + transactionAmount
				+ ", transactionType=" + transactionType + "]";
	}


}
