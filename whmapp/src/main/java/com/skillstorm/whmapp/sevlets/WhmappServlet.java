package com.skillstorm.whmapp.sevlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.whmapp.beans.Warehouse;
import com.skillstorm.whmapp.dao.WhmappDAO;


@WebServlet(name="whm-servlet", urlPatterns = "/whm")
public class WhmappServlet extends HttpServlet {

	/**
	 * The following are HTTP request that are sent to the FRont end from the Backed
	 * 
	 */
	private static final long serialVersionUID = -2611047757881591167L;
	//private CopyOnWriteArrayList<Warehouse> whmList = new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WHM-APP Get Request sent");
		List<Warehouse> whmList = null;
		try(WhmappDAO dao = new WhmappDAO()){
			whmList = dao.findAll();							// doGet Requests and returns data from the Database to the Front Ende
		}catch(Exception e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(whmList);
		resp.setContentType("application/json");
		resp.getWriter().print(json);
	}
	
	
	//do post method Creates and Adds entities to the Database
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WHMAPP Post request sent");
		ObjectMapper mapper = new ObjectMapper();
		InputStream reqbody = req.getInputStream();
		Warehouse warehouse = mapper.readValue(reqbody, Warehouse.class);
		try(WhmappDAO dao = new WhmappDAO()){
		 dao.save(warehouse);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//whmList.add(warehouse);
		resp.setStatus(201);
		System.out.println("Created Warehouse!");
		
		//home.setAddress("417 Leslie Street");
		//resp.setContentType("application/json");
		//resp.getWriter().print(mapper.writeValueAsString(warehouse));
		//System.out.println(home);
		//System.out.println();
	}
	//doPut gets a Update request from the database  and appends it to the Database.
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WHMAPP Put request sent");
		ObjectMapper mapper = new ObjectMapper();
		InputStream reqbody = req.getInputStream();
		Warehouse warehouse = mapper.readValue(reqbody, Warehouse.class);
		try(WhmappDAO dao = new WhmappDAO()){
		 dao.update(warehouse);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//whmList.add(warehouse);
		resp.setStatus(201);
		System.out.println("Updated Warehouse!");
		
	}
	// Usses An HTTP request from the Front end to Delete Data from the Back end database.
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WHMAPP Delete request sent");
		ObjectMapper mapper = new ObjectMapper();
		InputStream reqbody = req.getInputStream();
		Warehouse warehouse = mapper.readValue(reqbody, Warehouse.class);
		try(WhmappDAO dao = new WhmappDAO()){
		 dao.delete(warehouse);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//whmList.add(warehouse);
		resp.setStatus(201);
		System.out.println("Delete Warehouse!");
	}
}
