package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Pharmacist;


public class PharmacistDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Pharmacist p)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into pharmacist values('"+p.getPharmacistId()+"','"+p.getPhName()+"','"+p.getPhEmail()+"','"+p.getPhpwd()+"','"+p.getPhadd()+"','"+p.getPhph()+"')";
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
	  String query="select * from pharmacist";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Pharmacist displayById(String phid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from pharmacist where pharmacistid='"+phid+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		 Pharmacist p=new Pharmacist();
		 p.setPharmacistId(rs.getString(1));
		 p.setPhName(rs.getString(2));
		 p.setPhEmail(rs.getString(3));
		 p.setPhpwd(rs.getString(4));
		 p.setPhadd(rs.getString(5));
		 p.setPhph(rs.getString(6));
	  return(p);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String phid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from pharmacist where pharmacistid='"+phid+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Pharmacist p)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update pharmacist set pharmacistname='"+p.getPhName()+"',pharmacistemail='"+p.getPhEmail()+"',pharmacistpassword='"+p.getPhpwd()+"',pharmacistaddress='"+p.getPhadd()+"',pharmacistphone='"+p.getPhph()+"' where pharmacistid='"+p.getPharmacistId()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
	
}
