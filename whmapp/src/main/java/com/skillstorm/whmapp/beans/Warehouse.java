// Java Bean File
package com.skillstorm.whmapp.beans;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Warehouse {
	
	//@JsonIgnoreProperties({"warehouse_id"}) // Variables that will link to the Database
	private int warehouse_id;
	private String warehouse_name;
	private String warehouse_location;
	private int warehouse_size;
	
	/*
	 * 
	 * Multiple Constructors are created
	**/
	public Warehouse() {
		//super();
	}
	


	public Warehouse(int warehouse_id) {
		//super();
		this.warehouse_id = warehouse_id;
	}



	public Warehouse(String warehouse_name) {
		//super();
		this.warehouse_name = warehouse_name;
	}
	


	public Warehouse(String warehouse_name, String warehouse_location) {
		//super();
		this.warehouse_name = warehouse_name;
		this.warehouse_location = warehouse_location;
	}
	
	public Warehouse(String warehouse_name, int warehouse_id) {
		//super();
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
	}



	public Warehouse(int warehouse_id, String warehouse_name) {
		//super();
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
	}
	


	public Warehouse(String warehouse_name, String warehouse_location, int warehouse_size) {
		//super();
		this.warehouse_name = warehouse_name;
		this.warehouse_location = warehouse_location;
		this.warehouse_size = warehouse_size;
	}



	public Warehouse(int warehouse_id, String warehouse_name, String warehouse_location) {
		//super();
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
		this.warehouse_location = warehouse_location;
	}


	public Warehouse(int warehouse_id, String warehouse_name, String warehouse_location, int warehouse_size) {
		//super();
		this.warehouse_id = warehouse_id;
		this.warehouse_name = warehouse_name;
		this.warehouse_location = warehouse_location;
		this.warehouse_size = warehouse_size;
	}
/**
 * These are Getters and Setters to  pases data
 * @return
 */

	public int getWarehouse_id() {
		return warehouse_id;
	}


	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}


	public String getWarehouse_name() {
		return warehouse_name;
	}


	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}


	public String getWarehouse_location() {
		return warehouse_location;
	}


	public void setWarehouse_location(String warehouse_location) {
		this.warehouse_location = warehouse_location;
	}


	public int getWarehouse_size() {
		return warehouse_size;
	}


	public void setWarehouse_size(int warehouse_size) {
		this.warehouse_size = warehouse_size;
	}


// To String to convert Data into a readable Format.
	@Override
	public String toString() {
		return "Warehouse [warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name
				+ ", warehouse_location=" + warehouse_location + ", warehouse_size=" + warehouse_size + "]";
	}


	
	
	
	
	
	
	
	
	
	

}
