package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Accountant;
import com.mith.model.Nurse;

public class AccountantDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Accountant a)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into accountant values('"+a.getAccountantId()+"','"+a.getAName()+"','"+a.getAEmail()+"','"+a.getApwd()+"','"+a.getAadd()+"','"+a.getAph()+"','"+a.getAicon()+"')";
			boolean st=DBHelper.executeUpdate(query, cn);
			System.out.println(query);
			return(st);
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return(false);
		}


	}


	public static ResultSet displayAll()
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from accountant";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Accountant displayById(String acid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from accountant where accountantid='"+acid+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		  Accountant a=new Accountant();
		  a.setAccountantId(rs.getString(1));
		  a.setAName(rs.getString(2));
		  a.setAEmail(rs.getString(3));
		  a.setApwd(rs.getString(4));
		  a.setAadd(rs.getString(5));
		  a.setAph(rs.getString(6));
		  a.setAicon(rs.getString(7));
	  return(a);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String acid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from accountant where accountantid='"+acid+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Accountant a)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update accountant set accountantname='"+a.getAName()+"',accountantemail='"+a.getAEmail()+"',accountantpassword='"+a.getApwd()+"',accountantaddress='"+a.getAadd()+"',accountantphone='"+a.getAph()+"' where accountantid='"+a.getAccountantId()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   if( a.getAicon().length()>0)
	   {
		query="update accountant set accountanticon='"+a.getAicon()+"' where accountantid='"+a.getAccountantId()+"'";
	    st=DBHelper.executeUpdate(query, cn); 
	   }
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
