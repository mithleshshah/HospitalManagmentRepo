package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Patient;

public class PatientDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Patient p)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into patient values('"+p.getPatientid()+"','"+p.getPName()+"','"+p.getPEmail()+"','"+p.getPpwd()+"','"+p.getPAdress()+"','"+p.getPphone()+"','"+p.getPsex()+"','"+p.getPdob()+"','"+p.getPage()+"','"+p.getPbg()+"','"+p.getPicon()+"')";
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
	  String query="select * from patient";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Patient displayById(String pid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from patient where patientid='"+pid+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {Patient p=new Patient();
	  p.setPatientid(rs.getString(1));
	  p.setPName(rs.getString(2));
	  p.setPEmail(rs.getString(3));
	  p.setPpwd(rs.getString(4));
	  p.setPAdress(rs.getString(5));
	  p.setPphone(rs.getString(6));
	  p.setPsex(rs.getString(7));
	  p.setPdob(rs.getString(8));
	  p.setPage(rs.getString(9));
	  p.setPbg(rs.getString(10));
	  p.setPicon(rs.getString(11));
	  return(p);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String pid)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from patient where patientid='"+pid+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Patient p)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update patient set patientname='"+p.getPName()+"',doctoremail='"+p.getPEmail()+"',patientpassword='"+p.getPpwd()+"',patientaddress='"+p.getPAdress()+"',patientphone='"+p.getPphone()+"',patientsex='"+p.getPsex()+"',patientdob='"+p.getPdob()+"',patientage='"+p.getPage()+"',patientbg='"+p.getPbg()+"' where patientid='"+p.getPatientid()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   if( p.getPicon().length()>0)
	   {
		query="update patient set patienticon='"+p.getPicon()+"' where patientid='"+p.getPatientid()+"'";
	    st=DBHelper.executeUpdate(query, cn); 
	   }
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}	
	
}
