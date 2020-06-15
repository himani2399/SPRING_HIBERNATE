package com.firstHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try 
		{
			System.out.println("Connecting to Database..."+ jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Established");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		

	}

}
