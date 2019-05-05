package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Report;


public class ReportDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Report r)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into report values('"+r.getReportNo()+"','"+r.getType()+"','"+r.getReport()+"','"+r.getRdesc()+"','"+r.getRdate()+"','"+r.getDocname()+"','"+r.getPatname()+"')";
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
	  String query="select * from report";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Report displayById(String rno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from report where reportno='"+rno+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		  Report r=new Report();
		  r.setReportNo(rs.getString(1));
		  r.setType(rs.getString(2));
		  r.setReport(rs.getString(3));
		  r.setRdesc(rs.getString(4));
		  r.setRdate(rs.getString(5));
		  r.setDocname(rs.getString(6));
		  r.setPatname(rs.getString(7));
	  return(r);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String rno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from report where reportno='"+rno+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Report r)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update report set type='"+r.getType()+"',description='"+r.getRdesc()+"',date='"+r.getRdate()+"',doctor='"+r.getDocname()+"',patient='"+r.getPatname()+"' where reportno='"+r.getReportNo()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	  if( r.getReport().length()>0)
	   {
		query="update report set report='"+r.getReport()+"' where reportno='"+r.getReportNo()+"'";
	    st=DBHelper.executeUpdate(query, cn); 
	   }
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
