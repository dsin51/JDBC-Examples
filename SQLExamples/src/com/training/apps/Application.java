package com.training.apps;

import java.util.*;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;


public class Application {

	public static void main(String[] args) {

//		System.out.println(SqlConnection.getOracleConnection());
		
		
		/*
		 * Inserting values into Customer table
		 */
		Customer cust = new Customer(102,"Rajesh","aaa@pqr.com",12345);
		CustomerDAO dao = new CustomerDAO();
		int rowAdded = dao.add(cust);
		System.out.println(rowAdded+" row[s] added.");
		
		
		CustomerDAO dao1 = new CustomerDAO();
		Customer details = dao1.find(102);
		System.out.println(details);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("List of all Customers:");
		List<Customer> list =  dao1.findAll();
		
//		for (Customer i : list) 
//			System.out.println(i); 
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) 
		{
			Customer customer = (Customer) iterator.next();
			System.out.println(customer);
		}
		
		
		
		System.out.println("~~~Deletion~~~");
		System.out.println("Enter the customer id to be deleted(give 102 for testing)");
		Scanner sin = new Scanner(System.in);
		int custid = sin.nextInt();
		
		int rowsDeleted = dao1.delete(custid);
		if (rowsDeleted == 0) {
			System.out.println("Customer with ID:"+custid+" does not exist");
		} else {
			System.out.println(rowsDeleted+" row[s] deleted successfully");
		}
		
	}

}
