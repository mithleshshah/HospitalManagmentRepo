package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.NBed;

public class NBedDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(NBed n)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into bed values('"+n.getBedNo()+"','"+n.getWard()+"','"+n.getDescription()+"')";
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
	  String query="select * from bed";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static NBed displayById(String bno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from bed where bednumber='"+bno+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		  NBed b=new NBed();
		  b.setBedNo(rs.getString(1));
		  b.setWard(rs.getString(2));
		  b.setDescription(rs.getString(3));
		  return(b);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String bno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from bed where bednumber='"+bno+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(NBed b)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update bed set ward='"+b.getWard()+"',description='"+b.getDescription()+"' where bednumber='"+b.getBedNo()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}	
}
