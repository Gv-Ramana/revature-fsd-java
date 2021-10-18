package com.revature.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

@Path ("/transactions")
public class TransactionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	AccountDaoImpl dao = new AccountDaoImpl();

	@PUT
	@Path("/deposit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deposit(Account depositDetails) {
		
		try {
			Account account = dao.currentAccount(depositDetails.getAccountNumber());
			double newBalance = account.getBalance();
			newBalance += depositDetails.getBalance();
			account.setBalance(newBalance);
			dao.insert(new Transaction('C', depositDetails.getBalance()));
			dao.update(account);
			return Response.status(200).build();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return Response.ok().build();
		}
	}
	
	@PUT
	@Path("/withdraw")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response withdraw(Account withdrawDetails) {
		
		try {
			Account account = dao.currentAccount(withdrawDetails.getAccountNumber());
			double newBalance = account.getBalance();
			newBalance -= withdrawDetails.getBalance();
			account.setBalance(newBalance);
			dao.insert(new Transactions('D', withdrawDetails.getBalance()));
			dao.update(account);
			return Response.status(200).build();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		try {
			List<Transactions> transactionList;
			transactionList = dao.transactionList(id);
			System.out.println(transactionList);
			System.out.println(CustomerDaoImpl.currentCustomerId);
			return Response
					.ok()
					.entity(transactionList)
					.build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
	
}
