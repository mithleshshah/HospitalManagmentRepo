package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Prescription;

public class PrescriptionDao {
	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Prescription p)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into prescription values('"+p.getPno()+"','"+p.getPdname()+"','"+p.getPpname()+"','"+p.getPcs()+"','"+p.getPmd()+"','"+p.getPmdp()+"','"+p.getPdesc()+"','"+p.getPdate()+"')";
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
	  String query="select * from prescription";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Prescription displayByPname(String pname)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from prescription where patient='"+pname+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {Prescription p=new Prescription();
	  p.setPno(rs.getString(1));
	  p.setPdname(rs.getString(2));
	  p.setPpname(rs.getString(3));
	  p.setPcs(rs.getString(4));
	  p.setPmd(rs.getString(5));
	  p.setPmdp(rs.getString(6));
	  p.setPdesc(rs.getString(7));
	  p.setPdate(rs.getString(8));
	  return(p);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Prescription displayById(String pno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from prescription where prescriptionno='"+pno+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {Prescription p=new Prescription();
	  p.setPno(rs.getString(1));
	  p.setPdname(rs.getString(2));
	  p.setPpname(rs.getString(3));
	  p.setPcs(rs.getString(4));
	  p.setPmd(rs.getString(5));
	  p.setPmdp(rs.getString(6));
	  p.setPdesc(rs.getString(7));
	  p.setPdate(rs.getString(8));
	  return(p);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String pno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from prescription where prescriptionno='"+pno+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Prescription p)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update prescription set doctor='"+p.getPdname()+"',patient='"+p.getPpname()+"',casehistory='"+p.getPcs()+"',medication='"+p.getPmd()+"',medicationfp='"+p.getPmdp()+"',description='"+p.getPdesc()+"',date='"+p.getPdate()+"' where prescriptionno='"+p.getPno()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
