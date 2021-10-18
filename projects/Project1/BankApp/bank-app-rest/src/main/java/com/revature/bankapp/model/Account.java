package com.revature.bankapp.model;

import java.sql.SQLException;

import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;

public class Account {
	
	
	protected   String accountNumber;
	protected  double balance;
	protected int customerId;
	protected   String First_Name;
	protected   String Last_Name;
	protected   String Email;
	protected   int id;
	public Account() {
		
	}
	TransactionDaoImpl tdao = new TransactionDaoImpl();
	
	public Account(String accountNumber, double balance) {
		super();
		
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_Name() {
		return First_Name;
	}


	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}


	


	/*public double withdraw(double amount) {
		if (balance < amount) {
			System.out.println("Transaction Canont be Implied");}
		else if (balance >= amount) {
			balance -= amount;
			System.out.println(" WithDraw successfull");
			try {
				tdao.insert(new Transaction('w',amount));
				tdao.update(this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			return balance;
	}
	
	/*public double deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Transaction Canont be Implied");}
		else if (balance >= amount) {
			balance+=amount;
			System.out.println(" Deposite successfull");
			
			try {
				tdao.insert(new Transaction('d',amount));
				tdao.update(this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			return balance;
	}*/
	/*public void transfer(double amount) {
		balance += amount;
		try {
			AccountDaoImpl.insertTransfer(new Transaction('C', amount));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			AccountDaoImpl.updateTransfer(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	
	
	
	
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public  String getAccountNumber() {
		return accountNumber;
	}
	public  double getBalance() {
		return balance;
	}

//	public void setBalance(long l) {
//		this.balance = l;
//	}

	public int getCustomerId() {
		return customerId;
	}



	public String getLast_Name() {
		return Last_Name;
	}



	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", customerId=" + customerId
				+ ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Email=" + Email + ", id=" + id + "]";
	}





	


	

	


	

	
	
	

}
