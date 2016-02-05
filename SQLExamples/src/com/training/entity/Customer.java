package com.training.entity;


public class Customer {
	
	private int customerId;
	private String customerName;
	private String email;
	private int handPhone;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public Customer(int customerId, String customerName, String email, int handPhone)
	//throws RangeCheckException
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.handPhone = handPhone;
		
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHandPhone() {
		return handPhone;
	}
	public void setHandPhone(int handPhone) {
	
			this.handPhone = handPhone;
		
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", handPhone=" + handPhone + "]";
	}

	public String showCustomer() {
		
		String cust = customerId + ":" + customerName + ":" + email + ":" + handPhone;
		return cust;
		
	}
}
