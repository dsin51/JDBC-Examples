package com.training.apps;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;


public class Application {

	public static void main(String[] args) {

//		System.out.println(SqlConnection.getOracleConnection());
		
		Customer cust = new Customer(102,"Rajesh","aaa@pqr.com",12345);
		CustomerDAO dao = new CustomerDAO();
		int rowAdded = dao.add(cust);
		System.out.println(rowAdded+" row[s] added.");
		
	}

}
