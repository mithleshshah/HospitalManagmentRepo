package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.DAppointment;


public class DAppointmentDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(DAppointment a)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into appointment values('"+a.getApno()+"','"+a.getDoctor()+"','"+a.getPatient()+"','"+a.getApdate()+"')";
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
	  String query="select * from appointment";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static DAppointment displayById(String apno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from appointment where appointmentno='"+apno+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		  DAppointment a=new DAppointment();
		  a.setApno(rs.getString(1));
		  a.setDoctor(rs.getString(2));
		  a.setPatient(rs.getString(3));
		  a.setApdate(rs.getString(4));
	  return(a);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String apno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from appointment where appointmentno='"+apno+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(DAppointment a)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update appointment set patient='"+a.getPatient()+"',apdate='"+a.getApdate()+"' where appointmentno='"+a.getApno()+"' and doctor='"+a.getDoctor()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
