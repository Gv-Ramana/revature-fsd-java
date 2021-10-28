package com.revature.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;

@Path("/employees")
public class EmployeeController {
	@GET
	@Path("/{userName}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("userName") String userName, @PathParam("password")  String password) {
		System.out.println("Employee userName: " + userName);
		try {
		
		   EmployeeDaoImpl empl = new EmployeeDaoImpl();
			Employee employee = empl. getEmployeeUserName(userName);
			if (employee == null) {
				return Response.status(401).build();
			}
			else if (employee.getPassword().equals(password)) {
				System.out.println("Success");
				return Response
						.ok()
						.entity(employee)
						.build();
			} else {
				System.out.println("failed");
				return Response.status(401).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	
  
  }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		try {
			List<Customer> viewCustomer;
			 EmployeeDaoImpl empl = new EmployeeDaoImpl();
			 viewCustomer = empl.viewCustomer();
			
			System.out.println(viewCustomer);
			return Response
					.ok()
					.entity(viewCustomer)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}

	
	
	
	
	
	
}