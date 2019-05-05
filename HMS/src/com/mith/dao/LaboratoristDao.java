package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Accountant;
import com.mith.model.Laboratorist;

public class LaboratoristDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Laboratorist l)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into laboratorist values('"+l.getLaboratoristId()+"','"+l.getLName()+"','"+l.getLEmail()+"','"+l.getLpwd()+"','"+l.getLadd()+"','"+l.getLph()+"')";
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
	  String query="select * from laboratorist";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Laboratorist displayById(String lid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from laboratorist where laboratoristid='"+lid+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		 Laboratorist l=new Laboratorist();
		 l.setLaboratoristId(rs.getString(1));
		 l.setLName(rs.getString(2));
		 l.setLEmail(rs.getString(3));
		 l.setLpwd(rs.getString(4));
		 l.setLadd(rs.getString(5));
		 l.setLph(rs.getString(6));
	  return(l);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String lid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from laboratorist where laboratoristid='"+lid+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Laboratorist l)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update laboratorist set laboratoristname='"+l.getLName()+"',laboratoristemail='"+l.getLEmail()+"',laboratoristpassword='"+l.getLpwd()+"',laboratoristaddress='"+l.getLadd()+"',laboratoristphone='"+l.getLph()+"' where laboratoristid='"+l.getLaboratoristId()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
