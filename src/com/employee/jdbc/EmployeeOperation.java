package com.employee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeOperation {
	
	static Connection con=null;
	static PreparedStatement pst =null;
	static ResultSet rs=null;
	static String url="jdbc:mysql://127.0.0.1/emp_db";
	static String user="root";
	static String pass="admin";
//	static String database;
	static String tablename="employee";
	

	public static void finaly() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
//	public static void createDatabase(String db) {
//		database=db;
//		String query="create database "+db+" ";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection(url,user,pass);
//			pst=con.prepareStatement(query);
//			pst.execute();
//			System.out.println("DataBase Created");
//			
//		}catch(ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}finally {
//			finaly();
//		}
//	}
//	public static void createtable(String tn) {
//		tablename=tn;
//		String query="create table "+tn+" (eid int not null, ename varchar(40) not null,"
//				+ " esalary bigint(20) not null, job varchar(30) not null, primary key(eid))";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection(url+"/"+database,user,pass);
//			pst=con.prepareStatement(query);
//			boolean res=pst.execute();
//			if(!res) {
//				System.out.println("Table Created");
//			}
//		} catch (ClassNotFoundException |SQLException e) {
//			
//			
//			e.printStackTrace();
//		}finally {
//			finaly();
//		}
//		
//		
//	}
	
	public void addEmp(int eid,String ename,double esal,String job) {
		String query="insert into " +tablename+ " values(?, ?, ?, ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			pst.setInt(1, eid);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4,job );
			boolean res=pst.execute();
			if(!res) {
				System.out.println("Employee is being added");
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
	}
	
	public void deleteEmp(int eid) {
		String query="delete from "+tablename+" where eid = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			pst.setInt(1, eid);
			int res=pst.executeUpdate();
			System.out.println(res + " is being Deleted");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
	}
	public void updateEmpName(int eid,String ename) {
		String query="update "+tablename+" set ename=? where eid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			pst.setString(1, ename);
			pst.setInt(2, eid);
			int res=pst.executeUpdate();
			System.out.println(res +" is being updated");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
		
	}
	
	public void updateEmpSal(int eid,double esal) {
		String query="update "+tablename+" set esalary=? where eid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			pst.setDouble(1, esal);
			pst.setInt(2, eid);
			int res=pst.executeUpdate();
			System.out.println(res +" is being updated");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
		
	}
	public void updateEmpJob(int eid,String job) {
		String query="update "+tablename+" set job=? where eid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			pst.setString(1, job);
			pst.setInt(2, eid);
			int res=pst.executeUpdate();
			System.out.println(res +" is being updated");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
		
	}
	public void fetchParticularRecord(int eid) {
		String query="select * from "+tablename+ " where eid =?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			pst.setInt(1, eid);
			rs=pst.executeQuery();
			System.out.println("==============================");
			System.out.println("Id\tName\tSalary\tDesignation");
			System.out.println("==============================");
			if(rs.next()) {
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			}
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
		
	}
	
	public void fetchAllRecord() {
		String query="select * from "+tablename+ " ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			System.out.println("==============================");
			System.out.println("Id\tName\tSalary\tDesignation");
			System.out.println("==============================");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
				System.out.println();
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}finally {
			finaly();
		}
		
	}
	
	public int fetchEmployeeId() {
		int id=0;
		String query="select max(eid) from "+tablename;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			if(rs.next()) {
				id=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}finally {
			finaly();
			
		}
		return id;
		
	}

}
