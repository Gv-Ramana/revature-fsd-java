package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class InsertDemoPrepared {
	public static void main(String[] args) {
		Connection connection = null;
		 try {
			 new Driver();
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb",
					 "root","Ramana@2000");
			 String sql=" select * from employee";
			 PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 System.out.println(resultSet.getString("name"));
			 }
			  
			 connection.close();
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 } 
	}

}
