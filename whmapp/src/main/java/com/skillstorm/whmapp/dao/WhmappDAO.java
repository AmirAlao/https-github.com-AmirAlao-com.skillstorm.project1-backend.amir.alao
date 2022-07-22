package com.skillstorm.whmapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import com.skillstorm.whmapp.beans.Warehouse;

public class WhmappDAO implements whmappDAOInterface, AutoCloseable {
	
	// Main Method for Handling Tests
	public static void main(String[] args) {
		try(WhmappDAO dao = new WhmappDAO()){
			System.out.println(" whmAppDAO Connection Success");
			dao.update(new Warehouse("Amirat", 20));
			System.out.println(dao.delete(new Warehouse( 2)));
			
			
		}catch(Exception e) {
			System.out.println("whmAppDAO Connection Failed");
			e.printStackTrace();
		}
	}

	
	//connection process
private Connection connection;

public WhmappDAO()throws Exception {
	
	connect();
}

@Override
	public void close() throws Exception {// Closing connection.
	if(connection != null && !connection.isClosed()) {
		this.connection.close();
	}

		
}
	
	// Driver to Connect to Datatbase
	@SuppressWarnings("deprecation")
	public void connect() throws Exception{
		String url = "jdbc:mysql://localhost:3306/whmapp";
		String user = "root";
		String password = "root";
		
		//load Driver
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, user, password);
	}
	

	
	/**
	 * 		This Method Creates and Saves Data to the Database.
	 */
	@Override
	public boolean save(Warehouse warehouse) throws SQLException {
		String sql = "insert into warehouse(name, location, size) values (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, warehouse.getWarehouse_name());
		statement.setString(2, warehouse.getWarehouse_location());
		statement.setInt(3, warehouse.getWarehouse_size());
		int rows = statement.executeUpdate();
		
		return rows > 0 ? true:false;
	}

	/**
	 * 		This Method Searches and Retrieves Data from the Database.
	 */
	@Override
	public List<Warehouse> findAll() throws SQLException {
		String sql = "SELECT WAREHOUSE_ID, NAME, LOCATION, SIZE  FROM WAREHOUSE";
		List<Warehouse> results = new LinkedList<>();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			//do something
			Warehouse warehouse = new Warehouse(rs.getString("NAME"), rs.getString("LOCATION"), rs.getInt("SIZE"));
			warehouse.setWarehouse_id(rs.getInt("WAREHOUSE_ID"));
			results.add(warehouse);
		}
		return results;
	}
	
// Updates Data from the Data BAse
	@Override
	public boolean update(Warehouse warehouse) throws SQLException {
		String sql = "update warehouse set name = (?) where warehouse_id = (?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, warehouse.getWarehouse_name());
		statement.setInt(2, warehouse.getWarehouse_id());
		//statement.setInt(3, warehouse.getWarehouse_size());
		int rows = statement.executeUpdate();
		return rows > 0 ? true:false;
	}

	@Override
	public boolean delete(Warehouse warehouse) throws SQLException {
		String sql = "delete from warehouse where warehouse_id = (?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, warehouse.getWarehouse_id());
		//statement.setInt(2, warehouse.getWarehouse_id());
		//statement.setInt(3, warehouse.getWarehouse_size());
		int rows = statement.executeUpdate();
		return rows > 0 ? true:false;
	}
	
}
//Interface That has our Query Methods
interface whmappDAOInterface {
	//create
	public boolean save(Warehouse warehouse) throws SQLException;
	
	public boolean update(Warehouse warehouse) throws SQLException;
	
	public boolean delete(Warehouse warehouse) throws SQLException;
	
	//get
	public List<Warehouse> findAll() throws SQLException;
	
}