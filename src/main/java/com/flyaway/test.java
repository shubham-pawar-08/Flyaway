package com.flyaway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flyaway.Dao.UsersDaoImpl;
import com.flyaway.entities.Users;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1","root","kavin123");
			if(con!=null)
				System.out.println("success");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
