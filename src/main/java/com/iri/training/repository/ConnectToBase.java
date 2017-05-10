package com.iri.training.repository;

import java.sql.*;

public class ConnectToBase
{
	public static void main( String args[] )
	{
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\test.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql="SELECT * FROM USERS WHERE usrID= ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, 2);
			ResultSet rs = pst.executeQuery( );
			while ( rs.next() ) {
				int id = rs.getInt("usrID");
				String  Name = rs.getString("name");
				String Surname  = rs.getString("surname");
				String  Username = rs.getString("usrname");
				String Password = rs.getString("password");
				System.out.println( "ID = " + id );
				System.out.println( "NAME = " + Name );
				System.out.println( "surname= " + Surname );
				System.out.println( "usrname = " + Username );
				System.out.println( "password = " + Password );
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
}