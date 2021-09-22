package com.revature.app.jdbc;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;
 

public class JDBCDemo {

	public static void main(String[] args) {
		Connection connection = null;
		 try {
			 new Driver();
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb",
					 "root","Ramana@2000");
			 System.out.println(connection.getClass().getName());
			 System.out.println("connection done");
			 Statement statement = connection.createStatement();
			 statement.executeUpdate("insert into department(departmentname) values ('Innovation')");
			 connection.close();
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 connection.close();
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
		 }

	}

}
