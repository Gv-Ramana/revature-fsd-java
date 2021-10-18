//package com.revature.bankapp.controller;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
////import org.apache.log4j.Logger;
//
//import com.revature.bankapp.dao.EmployeeDao;
//import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
//import com.revature.bankapp.exception.AppException;
//import com.revature.bankapp.model.Customer;
//import com.revature.bankapp.model.Employee;
//import com.revature.bankapp.model.Transaction;
//
//@Path("/employees/{userName}/{password}")
//public class EmployeeController {
//	 
//	@GET
////	@Path("/{userName}/{password}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response get(@PathParam("userName") String userName, @PathParam("password")  String password) {
//		System.out.println("Employee userName: " + userName);
//		try {
//		
//		   EmployeeDaoImpl empl = new EmployeeDaoImpl();
//			Employee employee = empl. getEmployeeUserName(userName);
//			if (employee == null) {
//				return Response.status(401).build();
//			}
//			else if (employee.getPassword().equals(password)) {
//				System.out.println("Success");
//				return Response
//						.ok()
//						.entity(employee)
//						.build();
//			} else {
//				System.out.println("failed");
//				return Response.status(401).build();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return Response.status(500).build();
//		}
//	
//  
//  }
//	@GET
//	@Path("/{accountId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAccountTransactionList(@PathParam("accountId") long accountId) {
//		LOGGER.info("Account transaction listcalled for employee");
//		try {
//			ArrayList<Transaction> empTransList = (ArrayList<Transaction>) dao.showTransList(accountId);
//			return Response.ok().entity(empTransList).build();
//		} catch (AppException e) {
//			LOGGER.info("Failed to show transacctions");
//			e.printStackTrace();
//			return Response.status(500).build();
//		}
//		
//		
//	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response verifyLogin(Employee employee) {
//		LOGGER.info("EmployeeLogn method called");
//		LOGGER.debug("{}",employee);
//		if(employee.getEmail().equals("admin@gmail.com") && employee.getPassword().equals("password")) {
//			LOGGER.info("Employee login successfull");
//			return Response.ok().build();
//			
//		}else {
//			LOGGER.info("AccessDenied invalid Password");
//			return Response.status(401).build();
//		}
//	
//	}
//
//}







package com.revature.bankapp.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

@Path("/{employees}")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	EmployeeDao dao = new EmployeeDaoImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomersAccountList() {
		LOGGER.info("Calling customers called");
		try {
			ArrayList<Customer> custList = (ArrayList<Customer>) dao.showCustomerList();
			LOGGER.info("Showing Customers List successful");
			return Response.ok().entity(custList).build();
		} catch (AppException e) {
			LOGGER.info("Showing Customers failed");
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		
	}
	
	@GET
	@Path("/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountTransactionList(@PathParam("accountId") long accountId) {
		LOGGER.info("Account transaction listcalled for employee");
		try {
			ArrayList<Transaction> empTransList = (ArrayList<Transaction>) dao.showTransList(accountId);
			return Response.ok().entity(empTransList).build();
		} catch (AppException e) {
			LOGGER.info("Failed to show transacctions");
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response verifyLogin(Employee employee) {
		LOGGER.info("EmployeeLogn method called");
		LOGGER.debug("{}",employee);
		if(employee.getUserName().equals("admin@gmail.com") && employee.getPassword().equals("password")) {
			LOGGER.info("Employee login successfull");
			return Response.ok().build();
			
		}else {
			LOGGER.info("AccessDenied invalid Password");
			return Response.status(401).build();
		}
	
	}

}
