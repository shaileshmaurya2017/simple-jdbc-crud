package com.jdbcpractice;




import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("in main");
		//Insert(2,"gauranga");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection con = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb?user=root&password=root");
			
			PreparedStatement  prestate = con.prepareStatement(" select * from student");
			
			var status = prestate.executeQuery();
			while(status.next())
			{
				
				System.out.println("in main: "+status.getString(1)+" ::  "+status.getString(2));	
			}
		
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("in main :"+e.getMessage());
		}

	}
	
	public static void Insert(int id,String name) {
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			Connection con = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb?user=root&password=root");
			
			PreparedStatement  prestate = con.prepareStatement(" insert into student values(?,?)");
			prestate.setInt(1, id);
			prestate.setString(2, name);
			int status = prestate.executeUpdate();
			System.out.println("in main"+status);
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("in main :"+e.getMessage());
			
		}
		
	}

}
