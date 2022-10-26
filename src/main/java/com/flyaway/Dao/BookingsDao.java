package com.flyaway.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingsDao {
	
	public void insert(int fid, int cno, String expdate, int cvv, String pass, int pay, int persons, String tdate, String bookingtime) {
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1","root","kavin123");
			if(con!=null) {
				pst =con.prepareStatement("insert into bookings(flightId,cardNo,expiryDate,cvvNumber,PassDetails,paymentAmount,persons,traveldate,bookingTime) values(?,?,?,?,?,?,?,?,?)");
				pst.setInt(1, fid);
				pst.setInt(2, cno);
				pst.setString(3, expdate);
				pst.setInt(4, cvv);
				pst.setString(5, pass);
				pst.setInt(6,pay);
				pst.setInt(7, persons);
				pst.setString(8, tdate);
				pst.setString(9, bookingtime);
				int i=pst.executeUpdate();
				if(i>0) {
					System.out.println("Inserted Successfully");
				}
				else
				{
					System.out.println("Not inserted");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ResultSet getAll() {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1","root","kavin123");
			if(con!=null) {
				pst =con.prepareStatement("select * from bookings b,flights f where b.flightId=f.flightId;");
				rs=pst.executeQuery();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
}
