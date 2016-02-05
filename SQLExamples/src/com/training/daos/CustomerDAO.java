package com.training.daos;

import java.sql.*;
import java.util.List;
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
	public Customer find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
