package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Doctor;
import com.mith.model.Nurse;
import com.mith.model.Patient;

public class NurseDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Nurse n)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into nurse values('"+n.getNurseid()+"','"+n.getNurseName()+"','"+n.getNEmail()+"','"+n.getNpwd()+"','"+n.getNAdress()+"','"+n.getNphone()+"','"+n.getNIcon()+"')";
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
	  String query="select * from nurse";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Nurse displayById(String nid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from nurse where nurseid='"+nid+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		  Nurse n=new Nurse();
		  n.setNurseid(rs.getString(1));
		  n.setNurseName(rs.getString(2));
		  n.setNEmail(rs.getString(3));
		  n.setNpwd(rs.getString(4));
		  n.setNAdress(rs.getString(5));
		  n.setNphone(rs.getString(6));
		  n.setNIcon(rs.getString(7));
	  return(n);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String nid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from nurse where nurseid='"+nid+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Nurse n)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update nurse set nursename='"+n.getNurseName()+"',nurseemail='"+n.getNEmail()+"',nursepassword='"+n.getNpwd()+"',nurseaddress='"+n.getNAdress()+"',nursephone='"+n.getNphone()+"' where nurseid='"+n.getNurseid()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   if( n.getNIcon().length()>0)
	   {
		query="update nurse set nurseicon='"+n.getNIcon()+"' where nurseid='"+n.getNurseid()+"'";
	    st=DBHelper.executeUpdate(query, cn); 
	   }
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
		
	}	
	
