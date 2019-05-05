package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Doctor;


public class DoctorDao {
	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Doctor d)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into doctor values('"+d.getDoctorid()+"','"+d.getDocName()+"','"+d.getDEmail()+"','"+d.getDpwd()+"','"+d.getDAdress()+"','"+d.getDphone()+"','"+d.getDepartment()+"','"+d.getDIcon()+"')";
			boolean st=DBHelper.executeUpdate(query, cn);
			System.out.println();
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
	  String query="select * from doctor";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Doctor displayById(String doctorid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from doctor where doctorid='"+doctorid+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {Doctor d=new Doctor();
	  d.setDoctorid(rs.getString(1));
	  d.setDocName(rs.getString(2));
	  d.setDEmail(rs.getString(3));
	  d.setDpwd(rs.getString(4));
	  d.setDAdress(rs.getString(5));
	  d.setDphone(rs.getString(6));
	  d.setDepartment(rs.getString(7));
	  d.setDIcon(rs.getString(8));
	  return(d);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String doctorid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from doctor where doctorid='"+doctorid+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Doctor d)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update doctor set doctorname='"+d.getDocName()+"',doctoremail='"+d.getDEmail()+"',password='"+d.getDpwd()+"',doctoraddress='"+d.getDAdress()+"',doctorphone='"+d.getDphone()+"',department='"+d.getDepartment()+"' where doctorid='"+d.getDoctorid()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   if( d.getDIcon().length()>0)
	   {
		query="update doctor set icon='"+d.getDIcon()+"' where doctorid='"+d.getDoctorid()+"'";
	    st=DBHelper.executeUpdate(query, cn); 
	   }
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
