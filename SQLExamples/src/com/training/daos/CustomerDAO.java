package com.training.daos;

import java.sql.*;
import java.util.*;
import com.training.ifaces.DAO;
import com.training.utils.SqlConnection;
import com.training.entity.Customer;

public class CustomerDAO implements DAO<Customer> {
	
	
	private Connection con;
	
	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}

	public CustomerDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	/*
	 * @Method to insert values into Customer Table
	 */
	@Override
	public int add(Customer t) {

		String sql = "insert into Customer values(?,?,?,?)";
		int rowAdded = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,t.getCustomerId());
			pstmt.setString(2, t.getCustomerName());
			pstmt.setString(3, t.getEmail());
			pstmt.setInt(4, t.getHandPhone());
			
			rowAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowAdded;
	}

	@Override
	public Customer find(int key) {

		String sql = "Select * from Customer where customerid = ?";
		Customer cust = null;	
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, key);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("Customername");
				String email = rs.getString("email");
				int phone = rs.getInt("handphone");
				
				cust = new Customer(key,name,email,phone);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cust;
	}

	@Override
	public List<Customer> findAll() {

		String sql = "Select * from Customer";
		ArrayList<Customer> custlist = new ArrayList<Customer>();
		Customer cust=null;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				int custid = rs.getInt("Customerid");
				String name = rs.getString("Customername");
				String email = rs.getString("email");
				int phone = rs.getInt("handphone");
				
				cust = new Customer(custid,name,email,phone);
				custlist.add(cust);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return custlist;
	}

	@Override
	public int update(int key) {

		String sql1 = "update customer set email = ? where customerid = key";
		String sql2 = "update customer set handphone = ? where customerid = key";
		int rowsUpdated = 0;
		
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}

	@Override
	public int delete(int key) {

		String sql = "Delete from Customer where customerid = ?";
		int rowsDeleted = 0;
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			rowsDeleted = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rowsDeleted;
	}

}
